package com.homework.util;

import com.google.gson.Gson;
import com.homework.Dao.CourseDao;
import com.homework.models.ExangeCourse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Util {



    public static List<ExangeCourse> makeJson() throws IOException {
        List<ExangeCourse> exangeCourses = new ArrayList<>();
        String parse33 = "https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?valcode=USD&date=20240101&json";

        URL url = new URL(parse33);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        Gson gson = new Gson();
        try (BufferedReader reader = new BufferedReader
                (new InputStreamReader(conn.getInputStream()))) {
            StringBuilder result = new StringBuilder();
            for (String line; (line = reader.readLine()) != null; ) {
                result.append(line.replaceAll("]", "").replaceAll("\\[", ""));
            }

            ExangeCourse course = gson.fromJson(result.toString(), ExangeCourse.class);
            exangeCourses.add(new ExangeCourse(course.getTxt(), course.getRate(),
                    course.getCc(), course.getExchangedate()));

        }
        return exangeCourses;
    }



    public static List<ExangeCourse> getByTwoMonth() throws IOException {
        List<ExangeCourse> exangeCourses = new ArrayList<>();
        int x = 0;
        String c = "1";
        int leng = 32;

        while (x < 2) {
            String a = "0";

            for (int i = 1; i < leng; i++) {
                if (i == 10) {
                    a = "";
                }

                String parse33 = "https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?valcode=USD&date=20240" + c + a + i + "&json";

                URL url = new URL(parse33);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");

                Gson gson = new Gson();
                try (BufferedReader reader = new BufferedReader
                        (new InputStreamReader(conn.getInputStream()))) {
                    StringBuilder result = new StringBuilder();
                    for (String line; (line = reader.readLine()) != null; ) {
                        result.append(line.replaceAll("]", "").replaceAll("\\[", ""));
                    }

                    ExangeCourse course = gson.fromJson(result.toString(), ExangeCourse.class);
                    exangeCourses.add(new ExangeCourse( course.getRate(),
                            course.getCc(), course.getExchangedate()));
                }
            }
            leng = 30;
            c = "2";
            x++;
        }
        return exangeCourses;
    }


    public static void getByTwoMonth2(CourseDao dao ) throws IOException {
        int x = 0;
        String c = "1";
        int leng = 32;

        while (x < 2) {
            String a = "0";
            for (int i = 1; i < leng; i++) {
                if (i == 10) {
                    a = "";
                }
                String parse33 = "https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?valcode=USD&date=20240" + c + a + i + "&json";
                URL url = new URL(parse33);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                Gson gson = new Gson();
                try (BufferedReader reader = new BufferedReader
                        (new InputStreamReader(conn.getInputStream()))) {
                    StringBuilder result = new StringBuilder();
                    for (String line; (line = reader.readLine()) != null; ) {
                        result.append(line.replaceAll("]", "").replaceAll("\\[", ""));
                    }
                    ExangeCourse course = gson.fromJson(result.toString(), ExangeCourse.class);
                    dao.addCourse(new ExangeCourse(course.getRate(),
                            course.getCc(), course.getExchangedate()));
                }
            }
            leng = 30;
            c = "2";
            x++;
        }
    }


}
