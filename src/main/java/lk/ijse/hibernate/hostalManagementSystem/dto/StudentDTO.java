package lk.ijse.hibernate.hostalManagementSystem.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Transient;
import lk.ijse.hibernate.hostalManagementSystem.entity.Room;
import lk.ijse.hibernate.hostalManagementSystem.entity.Student;

public class StudentDTO {
    private String studentID;
    private String name;
    private String address;
    private String contactNo;
    private String dob;
    private String gender;

    public StudentDTO() {
    }

    public StudentDTO(String studentID,String name, String address, String contactNo, String dob, String gender) {
        this.studentID=studentID;
        this.name = name;
        this.address = address;
        this.contactNo = contactNo;
        this.dob = dob;
        this.gender = gender;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    public Student toEntity() {
        Student student = new Student();
        student.setStudentID(this.studentID);
        student.setName(this.name);
        student.setAddress(this.address);
        student.setContactNo(this.contactNo);
        student.setDob(this.dob);
        student.getGender(this.gender);
        return student;
    }
}
