package lk.ijse.hibernate.hostalManagementSystem.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.hibernate.hostalManagementSystem.bo.BOFactory;
import lk.ijse.hibernate.hostalManagementSystem.bo.impl.ReservationBO;
import lk.ijse.hibernate.hostalManagementSystem.dto.ReservationDTO;
import lk.ijse.hibernate.hostalManagementSystem.dto.RoomDTO;
import lk.ijse.hibernate.hostalManagementSystem.entity.Room;
import lk.ijse.hibernate.hostalManagementSystem.entity.Student;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class RegistrationFormController implements Initializable {
    public AnchorPane root;
    public ComboBox cmbAvaiableRooms;
    public Label lblQty;
    public ComboBox cmbStudentId;
    public TextField txtStudentName;
    public TextField txtDate;
    public TextField txtKeyMoney;
    public Button btnAdd;
    public Label lblDate;
    public Label lblLogin;
    public ComboBox cmbRoomTypeID;
    public TextField txtRefID;
    public TextArea txtStatus;
    public ComboBox cmbMoneyStatus;
    private String[] prtType = {"AC", "Non AC",};
    private String[] status = {"All", "Paid","Pending"};

    private ReservationBO reservationBO = BOFactory.getBoFactory().getBo(BOFactory.BoType.RESERVATION);


    public void cmbAvaiableRoomsOnAction(ActionEvent actionEvent) {

    }

    public void lblQtyOnAction(MouseEvent mouseEvent) {

    }

    public void cmbStudentIdOnAction(MouseEvent mouseEvent) {
        String id= String.valueOf(cmbStudentId.getValue());
        try{
            Student student=reservationBO.getStudentDetails(id);
            String name=student.getName();
            txtStudentName.setText(name);

        }catch (Exception e){

        }

    }

    public void btnAddOnAction(ActionEvent actionEvent) {
        Student student=reservationBO.getStudentDetails(String.valueOf(cmbStudentId.getValue()));
        Room room=reservationBO.getRoomDetails(String.valueOf(cmbRoomTypeID.getValue()));

        ReservationDTO reservation=new ReservationDTO();
        reservation.setRes_id(txtRefID.getText());
        reservation.setDate(txtDate.getText());
        reservation.setStatus(String.valueOf(cmbMoneyStatus.getValue()));
        reservation.setStudent(student);
        reservation.setRoom(room);

        String id= String.valueOf(cmbStudentId.getValue());



        try {
            Room roomDetail=reservationBO.getRoomDetails(id);
            int qty=roomDetail.getQty();
            RoomDTO roomDTO=new RoomDTO();
            roomDTO.setRoomTypeId(String.valueOf(cmbRoomTypeID.getValue()));
            roomDTO.setType(String.valueOf(cmbRoomTypeID.getValue()));
            roomDTO.setKey_money(txtKeyMoney.getText());
            roomDTO.setQty(qty-1);

            reservationBO.addRegistration(reservation,roomDTO);
        }catch (Exception e){

        }
    }

    public void lblLoginOnAction(MouseEvent mouseEvent) throws IOException {
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/new_student_registration_form.fxml"))));
        stage.setTitle("Home Page");
        stage.centerOnScreen();
        stage.show();
    }
    private void loadStudentID() {
        try {
            ObservableList<String> obList = FXCollections.observableArrayList();
            List<Student> codes = reservationBO.getAll();

            for (Student code : codes) {
                obList.add(code.getStudentID());
            }
            cmbStudentId.setItems(obList);
        } catch (SQLException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "SQL Error!").show();
        }

    }
    private void loadRoomTypeID() {
        try {
            ObservableList<String> obList = FXCollections.observableArrayList();
            ObservableList<String> obListType = FXCollections.observableArrayList();
            List<Room> codes = reservationBO.getAllRoom();

            for (Room code : codes) {
                obList.add(code.getRoomTypeId());
                if(code.getQty()!=0){
                    obListType.add(code.getType());
                }
            }
            cmbAvaiableRooms.setItems(obListType);
            cmbRoomTypeID.setItems(obList);
        } catch (SQLException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "SQL Error!").show();
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cmbAvaiableRooms.getItems().addAll(prtType);
        cmbMoneyStatus.getItems().addAll(status);
        loadStudentID();
        loadRoomTypeID();
    }

    public void cmbRoomTypeIDOnAction(MouseEvent mouseEvent) {
        String id= String.valueOf(cmbRoomTypeID.getValue());
        try{
            Room room=reservationBO.getRoomDetails(id);
            String name=room.getKey_money();
            txtKeyMoney.setText(name);

        }catch (Exception e){

        }

    }

}
