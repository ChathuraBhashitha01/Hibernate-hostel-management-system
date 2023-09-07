package lk.ijse.hibernate.hostalManagementSystem.dao;

import lk.ijse.hibernate.hostalManagementSystem.dao.CrudDAO;
import lk.ijse.hibernate.hostalManagementSystem.entity.Reservation;
import org.hibernate.Session;

public interface ReservationDAO extends CrudDAO<Reservation,Integer> {
    void setSession(Session session);
}
