package com.homework.Dao;

import com.homework.models.ExchangeCourse;

import java.util.List;

public interface CourseDao {

    ExchangeCourse addCourse(ExchangeCourse course);

    List<ExchangeCourse> getAllCourses();
}
