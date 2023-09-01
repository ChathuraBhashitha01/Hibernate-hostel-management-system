package lk.ijse.hibernate.hostalManagementSystem.entity;

import javax.persistence.*;

@Entity
@Table(name = "Student")
public class Student {

    @Id
    @Column(name = "student_id")
    private String studentID;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
    @Column(name = "contact_no")
    private String contactNo;
    @Transient
    private String dob;
    @Column(name = "gender")
    private String gender;

    public Student() {
    }

    public Student(String studentID, String name, String address, String contactNo, String dob, String gender) {
        this.studentID = studentID;
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

    @Override
    public String toString() {
        return "Student{" +
                "studentID='" + studentID + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", contactNo='" + contactNo + '\'' +
                ", dob='" + dob + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
