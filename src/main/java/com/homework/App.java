package com.homework;

import com.homework.Dao.CourseDao;
import com.homework.Dao.CourseDaoImpl;
import com.homework.models.ExchangeCourse;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import static com.homework.util.Util.getByTwoMonth2;
import static com.homework.util.Util.makeJson;

public class App {
    public static void main(String[] args) throws IOException {


        CourseDao dao = new CourseDaoImpl();
        getByTwoMonth2(dao);

      //  for (ExchangeCourse course2: dao.getAllCourses()) {

     //       System.out.println(course2);
     //  }

     //  System.out.println( dao.getCoursesByDate(new Date(124,1,22)));

       List<ExchangeCourse> list = dao.getCoursesBy(new Date(124,1,22));
       System.out.println(list);

      // System.out.println(new Date(124,1,22));

    }
}