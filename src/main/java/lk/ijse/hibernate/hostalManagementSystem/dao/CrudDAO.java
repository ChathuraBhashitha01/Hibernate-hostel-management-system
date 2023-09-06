package lk.ijse.hibernate.hostalManagementSystem.dao;

public interface CrudDAO <T,ID>{
     ID save(T customer);

    T get(String id);

    void update(T customer);

    void delete(T customer);
}
