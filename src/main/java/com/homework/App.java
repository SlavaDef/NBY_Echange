package com.homework;

import com.homework.Dao.CourseDao;
import com.homework.Dao.CourseDaoImpl;
import com.homework.models.ExangeCourse;

import java.io.IOException;

import static com.homework.util.Util.getByTwoMonth2;

public class App {
    public static void main(String[] args) throws IOException {


        CourseDao dao = new CourseDaoImpl();
        getByTwoMonth2(dao);

        for (ExangeCourse course2: dao.getAllCourses()) {

            System.out.println(course2);
        }
    }
}