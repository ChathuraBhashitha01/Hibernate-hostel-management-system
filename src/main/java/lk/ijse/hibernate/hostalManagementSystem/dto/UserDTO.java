package lk.ijse.hibernate.hostalManagementSystem.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lk.ijse.hibernate.hostalManagementSystem.entity.Student;
import lk.ijse.hibernate.hostalManagementSystem.entity.User;

public class UserDTO {
    private String userName;
    private String password;

    public UserDTO() {
    }

    public UserDTO(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
    public User toEntity() {
        User user = new User();
        user.setUserName(this.userName);
        user.setPassword(this.password);
        return user;
    }
}
