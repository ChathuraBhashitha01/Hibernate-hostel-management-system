package lk.ijse.hibernate.hostalManagementSystem.dao.impl;

import jakarta.persistence.*;
import lk.ijse.hibernate.hostalManagementSystem.dao.StudentDAO;
import lk.ijse.hibernate.hostalManagementSystem.entity.Student;
import org.hibernate.Session;

import java.util.List;

public class StudentDAOImpl implements StudentDAO {
    private Session session;

    @Override
    public void setSession(Session session) {
        this.session=session;
    }

    @Override
    public List<Student> getAll() {
        String hql = "SELECT s FROM Student s ";
        Query query = session.createQuery(hql);
        //query.setParameter("student_id",ID);
        List<Student> list = query.getResultList();
        return list;
    }

    @Override
    public Integer save(Student student) {
        session.save(student);
        return 1;
    }

    @Override
    public Student get(String id) {
        return session.get(Student.class, id);
    }

    @Override
    public void update(Student student) {
        session.update(student);
    }

    @Override
    public void delete(Student student) {
        session.delete(student);
    }

}
