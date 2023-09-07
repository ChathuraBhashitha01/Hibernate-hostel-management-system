package lk.ijse.hibernate.hostalManagementSystem.bo;

import lk.ijse.hibernate.hostalManagementSystem.config.SessionFactoryConfig;
import lk.ijse.hibernate.hostalManagementSystem.dao.ReservationDAO;
import lk.ijse.hibernate.hostalManagementSystem.dao.RoomDAO;
import lk.ijse.hibernate.hostalManagementSystem.dao.StudentDAO;
import lk.ijse.hibernate.hostalManagementSystem.dao.impl.ReservationDAOImpl;
import lk.ijse.hibernate.hostalManagementSystem.dao.impl.RoomDAOImpl;
import lk.ijse.hibernate.hostalManagementSystem.dao.impl.StudentDAOImpl;
import lk.ijse.hibernate.hostalManagementSystem.dto.ReservationDTO;
import lk.ijse.hibernate.hostalManagementSystem.dto.RoomDTO;
import lk.ijse.hibernate.hostalManagementSystem.dto.StudentDTO;
import lk.ijse.hibernate.hostalManagementSystem.entity.Room;
import lk.ijse.hibernate.hostalManagementSystem.entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.List;

public class RegistrationBOImpl {
    private static RegistrationBOImpl registrationBO;
    private final StudentDAO studentDAO;
    private final RoomDAO roomDAO;
    private final ReservationDAO reservationDAO;

    private RegistrationBOImpl() {
        studentDAO = (StudentDAO) new StudentDAOImpl();
        roomDAO = (RoomDAO) new RoomDAOImpl();
        reservationDAO=(ReservationDAO) new ReservationDAOImpl();
    }

    public static RegistrationBOImpl getInstance() {
        return null == registrationBO
                ? registrationBO = new RegistrationBOImpl()
                : registrationBO;
    }
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
