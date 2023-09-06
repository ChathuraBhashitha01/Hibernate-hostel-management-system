package lk.ijse.hibernate.hostalManagementSystem.bo;

import lk.ijse.hibernate.hostalManagementSystem.config.SessionFactoryConfig;
import lk.ijse.hibernate.hostalManagementSystem.dao.StudentDAO;
import lk.ijse.hibernate.hostalManagementSystem.dao.impl.StudentDAOImpl;
import lk.ijse.hibernate.hostalManagementSystem.dto.StudentDTO;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class StudentRegistrationBOImpl {
    private static StudentRegistrationBOImpl studentRegistrationBOImpl;
    private final StudentDAO studentDAO;

    private StudentRegistrationBOImpl() {
        studentDAO = (StudentDAO) new StudentDAOImpl();
    }

    public static StudentRegistrationBOImpl getInstance() {
        return null == studentRegistrationBOImpl
                ? studentRegistrationBOImpl = new StudentRegistrationBOImpl()
                : studentRegistrationBOImpl;
    }

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
