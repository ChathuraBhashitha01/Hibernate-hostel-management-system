package lk.ijse.hibernate.hostalManagementSystem.dao.impl;

import lk.ijse.hibernate.hostalManagementSystem.dao.CrudDAO;
import lk.ijse.hibernate.hostalManagementSystem.entity.Room;
import lk.ijse.hibernate.hostalManagementSystem.entity.Student;
import org.hibernate.Session;

import java.util.List;

public interface StudentDAO extends CrudDAO<Student,Integer> {
    void setSession(Session session);
    List<Student> getAll();
}
