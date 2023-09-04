package lk.ijse.hibernate.hostalManagementSystem.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class RegistrationFormController {
    public AnchorPane root;
    public ComboBox cmbAvaiableRooms;
    public Label lblQty;
    public ComboBox cmbStudentId;
    public TextField txtStudentName;
    public TextField txtDate;
    public TextField txtRoomType;
    public TextField txtKeyMoney;
    public Button btnAdd;
    public Label lblDate;
    public Label lblLogin;

    public void cmbAvaiableRoomsOnAction(ActionEvent actionEvent) {

    }

    public void lblQtyOnAction(MouseEvent mouseEvent) {

    }

    public void cmbStudentIdOnAction(ActionEvent actionEvent) {

    }

    public void btnAddOnAction(ActionEvent actionEvent) {

    }

    public void lblLoginOnAction(MouseEvent mouseEvent) throws IOException {
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/new_student_registration_form.fxml"))));
        stage.setTitle("Home Page");
        stage.centerOnScreen();
        stage.show();
    }
}
