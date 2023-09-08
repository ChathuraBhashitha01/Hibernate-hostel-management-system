package lk.ijse.hibernate.hostalManagementSystem.bo.impl.custom;

import lk.ijse.hibernate.hostalManagementSystem.bo.impl.RoomBO;
import lk.ijse.hibernate.hostalManagementSystem.config.SessionFactoryConfig;
import lk.ijse.hibernate.hostalManagementSystem.dao.DAOFactory;
import lk.ijse.hibernate.hostalManagementSystem.dao.impl.RoomDAO;
import lk.ijse.hibernate.hostalManagementSystem.dto.RoomDTO;
import lk.ijse.hibernate.hostalManagementSystem.entity.Room;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class RoomBOImpl implements RoomBO {
    RoomDAO roomDAO = DAOFactory.getDaoFactory().getDao(DAOFactory.DaoType.ROOM);
    public int save(RoomDTO roomDTO) {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
            roomDAO.setSession(session);
            roomDAO.save(roomDTO.toEntity());
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
    public boolean update(RoomDTO roomDTO) {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
            roomDAO.setSession(session);
            roomDAO.update(roomDTO.toEntity());
            transaction.commit();
            session.close();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            session.close();
            e.printStackTrace();
            return false;
        }
    }
    public boolean delete(RoomDTO roomDTO) {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
            roomDAO.setSession(session);
            roomDAO.delete(roomDTO.toEntity());
            transaction.commit();
            session.close();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            session.close();
            e.printStackTrace();
            return false;
        }
    }

    public List<Room  > getAll() {
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
}
