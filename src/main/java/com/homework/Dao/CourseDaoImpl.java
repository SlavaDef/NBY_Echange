package com.homework.Dao;

import com.homework.models.ExchangeCourse;
import com.homework.storage.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Date;
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

    @Override
    public ExchangeCourse getCoursesByDate(Date date) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            Query<ExchangeCourse> query =
                    session.createNamedQuery("ExchangeCourse_By_Date", ExchangeCourse.class)
                            .setParameter("exchangedate", date);
            List<ExchangeCourse> resultLIst = query.list();
            transaction.commit();
            return resultLIst.get(0);
        }
        }

    @Override
    public List<ExchangeCourse> getCourseRates() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "select distinct from ExchangeCourse  where exchangedate < '2024-02-01'";
            Query<ExchangeCourse> query = session.createQuery(hql , ExchangeCourse.class);
            return query.list();
        }
    }

    @Override
    public List<ExchangeCourse> getCoursesBy(Date date) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            Query<ExchangeCourse> query =
                    session.createNamedQuery("ExchangeCourse_By", ExchangeCourse.class)
                            .setParameter("exchangedate", date);
            List<ExchangeCourse> resultLIst = query.list();
            transaction.commit();
            return resultLIst;
        }
    }
    }





