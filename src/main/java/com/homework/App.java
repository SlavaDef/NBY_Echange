package com.homework;

import com.homework.Dao.CourseDao;
import com.homework.Dao.CourseDaoImpl;
import com.homework.models.ExchangeCourse;

import java.io.IOException;
import java.util.List;

import static com.homework.util.Util.getByTwoMonth2;
import static com.homework.util.Util.makeJson;

public class App {
    public static void main(String[] args) throws IOException {


        CourseDao dao = new CourseDaoImpl();
        getByTwoMonth2(dao);

        for (ExchangeCourse course2: dao.getAllCourses()) {

            System.out.println(course2);
        }

     // List<ExchangeCourse> list =   makeJson();
     // System.out.println(list.get(0));
    }
}