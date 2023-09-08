package lk.ijse.hibernate.hostalManagementSystem.bo.impl.custom;

import lk.ijse.hibernate.hostalManagementSystem.bo.impl.ReservationBO;
import lk.ijse.hibernate.hostalManagementSystem.config.SessionFactoryConfig;
import lk.ijse.hibernate.hostalManagementSystem.dao.DAOFactory;
import lk.ijse.hibernate.hostalManagementSystem.dao.impl.ReservationDAO;
import lk.ijse.hibernate.hostalManagementSystem.dao.impl.RoomDAO;
import lk.ijse.hibernate.hostalManagementSystem.dao.impl.StudentDAO;
import lk.ijse.hibernate.hostalManagementSystem.dto.ReservationDTO;
import lk.ijse.hibernate.hostalManagementSystem.dto.RoomDTO;
import lk.ijse.hibernate.hostalManagementSystem.entity.Room;
import lk.ijse.hibernate.hostalManagementSystem.entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.List;

public class ReservationBOImpl implements ReservationBO {
    ReservationDAO reservationDAO = DAOFactory.getDaoFactory().getDao(DAOFactory.DaoType.RESERVATION);
    RoomDAO roomDAO = DAOFactory.getDaoFactory().getDao(DAOFactory.DaoType.ROOM);
    StudentDAO studentDAO=DAOFactory.getDaoFactory().getDao(DAOFactory.DaoType.STUDENT);
    public List<Student> getAll() throws SQLException {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try{
            studentDAO.setSession(session);
            List<Student> list= studentDAO.getAll();
            transaction.commit();
            session.close();
            return list;

        }catch (Exception e){
            return null;
        }
    }
    public List<Room> getAllRoom() throws SQLException {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try{
            roomDAO.setSession(session);
            List<Room> list= roomDAO.getAll();
            transaction.commit();
            session.close();
            return list;

        }catch (Exception e){
            return null;
        }
    }

    public Student getStudentDetails(String id) {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try{
            studentDAO.setSession(session);
            Student list= studentDAO.get(id);
            transaction.commit();
            session.close();
            return list;

        }catch (Exception e){
            return null;
        }
    }

    public Room getRoomDetails(String id) {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try{
            roomDAO.setSession(session);
            Room list= roomDAO.get(id);
            transaction.commit();
            session.close();
            return list;

        }catch (Exception e){
            return null;
        }
    }

    public void addRegistration(ReservationDTO reservation, RoomDTO roomDTO) {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        try {
            reservationDAO.setSession(session);
            reservationDAO.save(reservation.toEntity());
            roomDAO.setSession(session);
            roomDAO.update(roomDTO.toEntity());
            transaction.commit();
            session.close();

        }catch (Exception e){

        }
    }
}
