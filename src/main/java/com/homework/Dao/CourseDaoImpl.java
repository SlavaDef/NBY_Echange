package com.homework.Dao;

import com.homework.models.ExchangeCourse;
import com.homework.storage.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class CourseDaoImpl implements CourseDao {

    @Override
    public ExchangeCourse addCourse(ExchangeCourse course) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(course);
            transaction.commit();
            return course;
        }
    }

    @Override
    public List<ExchangeCourse> getAllCourses() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<ExchangeCourse> query = session.createQuery("from ExchangeCourse", ExchangeCourse.class);
            return query.list();
        }
    }

}

