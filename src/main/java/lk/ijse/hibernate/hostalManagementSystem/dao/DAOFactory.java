package lk.ijse.hibernate.hostalManagementSystem.dao;

import lk.ijse.hibernate.hostalManagementSystem.dao.impl.custom.ReservationDAOImpl;
import lk.ijse.hibernate.hostalManagementSystem.dao.impl.custom.RoomDAOImpl;
import lk.ijse.hibernate.hostalManagementSystem.dao.impl.custom.StudentDAOImpl;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory(){}

    public static DAOFactory getDaoFactory(){
        return (daoFactory==null) ? daoFactory = new DAOFactory() : daoFactory;
    }

    public enum DaoType {
        STUDENT,ROOM,RESERVATION
    }

    public <SuperDAO> SuperDAO getDao(DaoType daoType){
        switch (daoType){
            case STUDENT:
                return (SuperDAO) new StudentDAOImpl();
            case ROOM:
                return (SuperDAO) new RoomDAOImpl();
            case RESERVATION:
                return (SuperDAO) new ReservationDAOImpl();
            default:
                return null;
        }
    }

}
