package lk.ijse.hibernate.hostalManagementSystem.dao;

import lk.ijse.hibernate.hostalManagementSystem.entity.Room;
import lk.ijse.hibernate.hostalManagementSystem.entity.Student;
import org.hibernate.Session;

import java.util.List;

public interface RoomDAO extends CrudDAO<Room,Integer>{
    void setSession(Session session);
    List<Room> getAll();
}
