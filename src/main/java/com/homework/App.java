package com.homework;

import com.homework.Dao.CourseDao;
import com.homework.Dao.CourseDaoImpl;

import java.io.IOException;
import java.util.Date;


import static com.homework.util.Util.getByTwoMonth2;


public class App {
    public static void main(String[] args) throws IOException {

        CourseDao dao = new CourseDaoImpl();
        getByTwoMonth2(dao);

        System.out.println(dao.getCoursesByDate(new Date(124, 1, 22)));

        System.out.println(dao.getAvgCourseRates(new Date(124, 1, 10),
                new Date(124, 1, 30)));

    }
}