package com.homework.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.homework.Dao.CourseDao;
import com.homework.models.ExchangeCourse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Util {



    public static List<ExchangeCourse> makeJson() throws IOException {
        List<ExchangeCourse> exangeCourses = new ArrayList<>();
        String parse33 = "https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?valcode=USD&date=20240101&json";

        URL url = new URL(parse33);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        Gson gson = new Gson();
        ObjectMapper objectMapper = new ObjectMapper();
       // objectMapper.setDateFormat(new SimpleDateFormat("dd.MM.yyyy"));
        try (BufferedReader reader = new BufferedReader
                (new InputStreamReader(conn.getInputStream()))) {
            StringBuilder result = new StringBuilder();
            for (String line; (line = reader.readLine()) != null; ) {
                result.append(line.replaceAll("]", "").replaceAll("\\[", ""));
            }


            ExchangeCourse course = objectMapper.readValue(result.toString(), ExchangeCourse.class);
          //  ExchangeCourse course = gson.fromJson(result.toString(), ExchangeCourse.class);
            exangeCourses.add(new ExchangeCourse(course.getTxt(), course.getRate(),
                    course.getCc(), course.getExchangedate()));

        }
        return exangeCourses;
    }



    public static List<ExchangeCourse> getByTwoMonth() throws IOException {
        List<ExchangeCourse> exangeCourses = new ArrayList<>();
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

                    ExchangeCourse course = gson.fromJson(result.toString(), ExchangeCourse.class);
                    exangeCourses.add(new ExchangeCourse( course.getRate(),
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
                // Gson gson = new Gson();
                ObjectMapper objectMapper = new ObjectMapper();
                try (BufferedReader reader = new BufferedReader
                        (new InputStreamReader(conn.getInputStream()))) {
                    StringBuilder result = new StringBuilder();
                    for (String line; (line = reader.readLine()) != null; ) {
                        result.append(line.replaceAll("]", "").replaceAll("\\[", ""));
                    }
                    ExchangeCourse course = objectMapper.readValue(result.toString(), ExchangeCourse.class);
                    dao.addCourse(new ExchangeCourse(course.getRate(),
                            course.getCc(), course.getExchangedate()));
                }
            }
            leng = 30;
            c = "2";
            x++;
        }
    }


}
