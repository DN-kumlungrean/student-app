package com.example.studentapp.dao;

import com.example.studentapp.model.Student;
import jakarta.persistence.*;

import java.util.List;
import java.util.Optional;

public class StudentTable {

    private static final EntityManagerFactory emf =
        Persistence.createEntityManagerFactory("studentPU");

    public Optional<Student> findById(String id) {
        EntityManager em = emf.createEntityManager();
        try {
            return Optional.ofNullable(em.find(Student.class, id));
        } finally { em.close(); }
    }

    public boolean insertIfNotExists(Student s) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            if (em.find(Student.class, s.getStudentId()) != null) {
                return false; // duplicate
            }
            tx.begin();
            em.persist(s);
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            throw e;
        } finally { em.close(); }
    }

    public List<Student> listAll() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT s FROM Student s ORDER BY s.studentId", Student.class)
                     .getResultList();
        } finally { em.close(); }
    }
}
