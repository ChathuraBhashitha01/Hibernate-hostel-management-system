package lk.ijse.hibernate.hostalManagementSystem.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HomePageFormController {
    public AnchorPane root;

    public void btnRegistrationOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/registration_form.fxml"))));
        stage.setTitle("Home Page");
        stage.centerOnScreen();
        stage.show();

    }

    public void btnManageRoomsOnAction(ActionEvent actionEvent) {

    }

    public void btnKeyMoneyOnAction(ActionEvent actionEvent) {

    }
}
