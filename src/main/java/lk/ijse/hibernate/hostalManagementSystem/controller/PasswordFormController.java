package lk.ijse.hibernate.hostalManagementSystem.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import lk.ijse.hibernate.hostalManagementSystem.dto.UserDTO;

//public class PasswordFormController {
//    public ComboBox cmbUser;
//    public TextField txtUserName;
//    public TextField txtPassword;
//    public TextField txtNewUserName;
//    public TextField txtNewPassword;
//    public Button btnChangePassword;

//    UserBOImpl userBO= UserBOImpl.getInstance();
//
//    public void btnChangePasswordOnAction(ActionEvent actionEvent) {
//        String user = (String) cmbUser.getValue();
//        String userName=null;
//        String password=null;

//        User userDetail = userBO.get(user);
//            userName = userDetail.getUserName();
//            password = userDetail.getPassword();
//
//        if (txtUserName.getText().isEmpty()||txtPassword.getText().isEmpty()||((String) cmbUser.getValue()).isEmpty()) {
//            new Alert(Alert.AlertType.CONFIRMATION, "All Field Are Required:)").show();
//        } else {
//            if (cmbUser.getValue().equals(user) && txtUserName.getText().equals(userName) && txtPassword.getText().equals(password)) {
//                String newUserName = txtNewUserName.getText();
//                String newPassword = txtNewPassword.getText();
//
//                UserDTO userDTO =new UserDTO(newUserName,newPassword);
                //boolean isUpdated=
                      //  userBO.update(userDTO);
//                if (isUpdated) {
//                    new Alert(Alert.AlertType.CONFIRMATION, "updated!!").show();
//                }
//
//            } else {
//                new Alert(Alert.AlertType.CONFIRMATION,
//                        "Wrong :)")
//                        .show();
//            }
//      }
//    }
//}
