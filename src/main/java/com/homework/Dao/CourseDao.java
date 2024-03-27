package com.homework.Dao;

import com.homework.models.ExangeCourse;

import java.util.List;

public interface CourseDao {

    ExangeCourse addCourse(ExangeCourse course);

    List<ExangeCourse> getAllCourses();
}
