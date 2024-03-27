package com.homework.Dao;

import com.homework.models.ExchangeCourse;

import java.util.Date;
import java.util.List;

public interface CourseDao {

    ExchangeCourse addCourse(ExchangeCourse course);

    List<ExchangeCourse> getAllCourses();

    public Double getMaxCourseRates(Date from, Date to);

    ExchangeCourse getCoursesByDate(Date date);

    Double getMinCourseRates(Date from, Date to);

    Double getAvgCourseRates(Date from, Date to);

}
