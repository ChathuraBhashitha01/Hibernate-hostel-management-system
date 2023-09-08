package lk.ijse.hibernate.hostalManagementSystem.dao.impl;

import lk.ijse.hibernate.hostalManagementSystem.dto.CustomEntityDTO;
import org.hibernate.Session;

import java.util.List;

public interface QueryDAO {
    void setSession(Session session);
    List<CustomEntityDTO> getAll();
}
