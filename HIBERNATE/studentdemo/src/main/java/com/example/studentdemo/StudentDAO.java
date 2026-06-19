package com.example.studentdemo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class StudentDAO {

    private Session getSession() {
        return Utility.getSessionFactory().openSession();
    }

    public void save(Student s) {

        Session session = getSession();

        Transaction tx =
                session.beginTransaction();

        session.persist(s);

        tx.commit();

        session.close();
    }

    public Student findById(int id) {

        Session session = getSession();

        Student s =
                session.get(Student.class,id);

        session.close();

        return s;
    }

    public List<Student> findAll() {

        Session session = getSession();

        List<Student> list =
                session.createQuery(
                        "from Student",
                        Student.class)
                        .getResultList();

        session.close();

        return list;
    }

    public void update(Student s) {

        Session session = getSession();

        Transaction tx =
                session.beginTransaction();

        session.merge(s);

        tx.commit();

        session.close();
    }

    public void delete(int id) {

        Session session = getSession();

        Transaction tx =
                session.beginTransaction();

        Student s =
                session.get(Student.class,id);

        if(s!=null)
        {
            session.remove(s);
        }

        tx.commit();

        session.close();
    }
}