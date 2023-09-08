package lk.ijse.hibernate.hostalManagementSystem.dao.impl;

import lk.ijse.hibernate.hostalManagementSystem.dao.CrudDAO;
import lk.ijse.hibernate.hostalManagementSystem.entity.User;
import org.hibernate.Session;

public interface UserDAO extends CrudDAO<User,Integer> {
    void setSession(Session session);
}
