package lk.ijse.hibernate.hostalManagementSystem.bo.impl;

import lk.ijse.hibernate.hostalManagementSystem.config.SessionFactoryConfig;
import lk.ijse.hibernate.hostalManagementSystem.dto.RoomDTO;
import lk.ijse.hibernate.hostalManagementSystem.entity.Room;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public interface RoomBO {
    public int save(RoomDTO roomDTO);
    public boolean update(RoomDTO roomDTO);
    public boolean delete(RoomDTO roomDTO);
    public List<Room> getAll();
}
