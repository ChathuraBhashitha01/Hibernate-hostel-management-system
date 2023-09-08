package lk.ijse.hibernate.hostalManagementSystem.bo.impl.custom;

import lk.ijse.hibernate.hostalManagementSystem.bo.impl.StudentBO;
import lk.ijse.hibernate.hostalManagementSystem.config.SessionFactoryConfig;
import lk.ijse.hibernate.hostalManagementSystem.dao.DAOFactory;
import lk.ijse.hibernate.hostalManagementSystem.dao.impl.StudentDAO;
import lk.ijse.hibernate.hostalManagementSystem.dto.StudentDTO;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class StudentBOImpl implements StudentBO {
    StudentDAO studentDAO= DAOFactory.getDaoFactory().getDao(DAOFactory.DaoType.STUDENT);

    public int save(StudentDTO studentDTO) {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
            studentDAO.setSession(session);
            studentDAO.save(studentDTO.toEntity());
            transaction.commit();
            session.close();
            //return roomID;
            return 1;
        } catch (Exception e) {
            transaction.rollback();
            session.close();
            e.printStackTrace();
            return -1;
        }
    }
    public boolean update(StudentDTO studentDTO) {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
            studentDAO.setSession(session);
            studentDAO.update(studentDTO.toEntity());
            transaction.commit();
            session.close();
            //return roomID;
            return true;
        } catch (Exception e) {
            transaction.rollback();
            session.close();
            e.printStackTrace();
            return false;
        }
    }
    public boolean delete(StudentDTO studentDTO) {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
            studentDAO.setSession(session);
            studentDAO.delete(studentDTO.toEntity());
            transaction.commit();
            session.close();
            //return roomID;
            return true;
        } catch (Exception e) {
            transaction.rollback();
            session.close();
            e.printStackTrace();
            return false;
        }
    }
}
