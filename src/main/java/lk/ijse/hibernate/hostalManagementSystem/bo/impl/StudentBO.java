package lk.ijse.hibernate.hostalManagementSystem.bo.impl;

import lk.ijse.hibernate.hostalManagementSystem.config.SessionFactoryConfig;
import lk.ijse.hibernate.hostalManagementSystem.dto.StudentDTO;
import org.hibernate.Session;
import org.hibernate.Transaction;

public interface StudentBO {
    public int save(StudentDTO studentDTO);
    public boolean update(StudentDTO studentDTO);
    public boolean delete(StudentDTO studentDTO);
}
