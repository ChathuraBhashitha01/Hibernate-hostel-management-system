package lk.ijse.hibernate.hostalManagementSystem.dto;

import jakarta.persistence.Column;
import lk.ijse.hibernate.hostalManagementSystem.entity.Reservation;
import lk.ijse.hibernate.hostalManagementSystem.entity.Room;
import lk.ijse.hibernate.hostalManagementSystem.entity.Student;

import java.sql.Date;

public class ReservationDTO {
    private String res_id;
    private String date;
    private String status;
    private Student student;
    private Room room;

    public ReservationDTO() {
    }

    public ReservationDTO(String res_id, String date, String status, Student student, Room room) {
        this.res_id = res_id;
        this.date = date;
        this.status = status;
        this.student = student;
        this.room = room;
    }
    public String getRes_id() {
        return res_id;
    }

    public void setRes_id(String res_id) {
        this.res_id = res_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Reservation toEntity() {
        Reservation reservation = new Reservation();
        reservation.setRes_id(this.res_id);
        reservation.setDate(this.date);
        reservation.setStatus(this.status);
        reservation.setStudent(this.student);
        reservation.setRoom(this.room);
        return reservation;
    }
}
