package lk.ijse.hibernate.hostalManagementSystem.bo.impl;
import lk.ijse.hibernate.hostalManagementSystem.dto.ReservationDTO;
import lk.ijse.hibernate.hostalManagementSystem.dto.RoomDTO;
import lk.ijse.hibernate.hostalManagementSystem.entity.Room;
import lk.ijse.hibernate.hostalManagementSystem.entity.Student;
import java.sql.SQLException;
import java.util.List;

public interface ReservationBO {
    public List<Student> getAll() throws SQLException;
    public List<Room> getAllRoom() throws SQLException;
    public Student getStudentDetails(String id);
    public Room getRoomDetails(String id);
    public void addRegistration(ReservationDTO reservation, RoomDTO roomDTO);
}
