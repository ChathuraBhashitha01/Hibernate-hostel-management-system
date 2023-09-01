package lk.ijse.hibernate.hostalManagementSystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "reservation")
public class Reservation {
    @Id
    @Column(name = "res_id")
    private String res_id;
    @Column(name = "date")
    private Date date;
    @Column(name = "student_id")
    private String studentID;
    @Column(name = "room_type_id")
    private String roomTypeId;
    @Column(name = "status")
    private String status;

    public Reservation() {
    }

    public Reservation(String res_id, Date date, String studentID, String roomTypeId, String status) {
        this.res_id = res_id;
        this.date = date;
        this.studentID = studentID;
        this.roomTypeId = roomTypeId;
        this.status = status;
    }

    public String getRes_id() {
        return res_id;
    }

    public void setRes_id(String res_id) {
        this.res_id = res_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(String roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "res_id='" + res_id + '\'' +
                ", date=" + date +
                ", studentID='" + studentID + '\'' +
                ", roomTypeId='" + roomTypeId + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
