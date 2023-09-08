package lk.ijse.hibernate.hostalManagementSystem.dao.impl.custom;

import lk.ijse.hibernate.hostalManagementSystem.dao.impl.ReservationDAO;
import lk.ijse.hibernate.hostalManagementSystem.entity.Reservation;
import org.hibernate.Session;

public class ReservationDAOImpl implements ReservationDAO {
    private Session session;

    @Override
    public void setSession(Session session) {
        this.session=session;
    }
    @Override
    public Integer save(Reservation customer) {
        session.save(customer);
        return 1;
    }

    @Override
    public Reservation get(String id) {
        return null;
    }

    @Override
    public void update(Reservation customer) {
        session.update(customer);

    }

    @Override
    public void delete(Reservation customer) {
        session.delete(customer);
    }
}
