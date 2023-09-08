package lk.ijse.hibernate.hostalManagementSystem.dao.impl.custom;

import jakarta.persistence.Query;
import lk.ijse.hibernate.hostalManagementSystem.dao.impl.RoomDAO;
import lk.ijse.hibernate.hostalManagementSystem.entity.Room;
import org.hibernate.Session;

import java.util.List;

public class RoomDAOImpl implements RoomDAO {
    private Session session;

    @Override
    public void setSession(Session session) {
        this.session=session;
    }

    @Override
    public List<Room> getAll() {
        String hql = "SELECT s FROM Room s ";
        Query query = session.createQuery(hql);
        //query.setParameter("room_type_id",ID);
        List<Room> list = query.getResultList();
        return list;
    }

    @Override
    public Integer save(Room room) {
        session.save(room);
        return 1;
    }

    @Override
    public Room get(String id) {
        return session.get(Room.class, id);
    }

    @Override
    public void update(Room room) {
        session.update(room);

    }
    @Override
    public void delete(Room room) {
        session.delete(room);
    }

}
