package com.homework.Dao;

import com.homework.models.ExangeCourse;
import com.homework.storage.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class CourseDaoImpl implements CourseDao {

    @Override
    public ExangeCourse addCourse(ExangeCourse course) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(course);
            transaction.commit();
            return course;
        }
    }

    @Override
    public List<ExangeCourse> getAllCourses() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<ExangeCourse> query = session.createQuery("from ExangeCourse", ExangeCourse.class);
            return query.list();
        }
    }

}

