package com.homework.Dao;

import com.homework.models.ExchangeCourse;

import java.util.Date;
import java.util.List;

public interface CourseDao {

    ExchangeCourse addCourse(ExchangeCourse course);

    List<ExchangeCourse> getAllCourses();

    ExchangeCourse getCoursesByDate(Date date);

    List<ExchangeCourse> getCourseRates();

    List<ExchangeCourse> getCoursesBy(Date date);
}
