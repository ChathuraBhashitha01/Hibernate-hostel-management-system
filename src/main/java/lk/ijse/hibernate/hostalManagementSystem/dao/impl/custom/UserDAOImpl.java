package lk.ijse.hibernate.hostalManagementSystem.dao.impl.custom;

import lk.ijse.hibernate.hostalManagementSystem.dao.impl.UserDAO;
import lk.ijse.hibernate.hostalManagementSystem.entity.User;
import org.hibernate.Session;

public class UserDAOImpl implements UserDAO {
    private Session session;

    @Override
    public Integer save(User customer) {
        session.save(customer);
        return 1;
    }

    @Override
    public User get(String id) {
        return session.get(User.class, id);
    }

    @Override
    public void update(User customer) {
        session.update(customer);
    }

    @Override
    public void delete(User customer) {
        session.delete(customer);
    }

    @Override
    public void setSession(Session session) {
        this.session=session;
    }
}
