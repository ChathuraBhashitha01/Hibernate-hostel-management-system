package lk.ijse.hibernate.hostalManagementSystem.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.hibernate.hostalManagementSystem.bo.RoomManagementBOImpl;
import lk.ijse.hibernate.hostalManagementSystem.dto.RoomDTO;
import lk.ijse.hibernate.hostalManagementSystem.dto.dtm.RoomTM;
import lk.ijse.hibernate.hostalManagementSystem.entity.Room;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class RoomManagementFormController implements Initializable {

    public AnchorPane root;
    public TextField txtRoomTypeID;
    public TextField txtKeyMoney;
    public TextField txtQuantity;
    public ComboBox cmbType;
    public TableView tblRoom;
    public TableColumn colID;
    public TableColumn colType;
    public TableColumn colKeyMoney;
    public TableColumn colQuantity;
    public TableColumn colAvailable;
    public Button btnSave;
    public Button btnUpdate;
    public Button btnDelete;

    private String[] prtType = {"AC", "Non AC",};
    RoomManagementBOImpl roomBO= RoomManagementBOImpl.getInstance();

    public void btnSaveOnAction(ActionEvent actionEvent) {
        String id=txtRoomTypeID.getText();
        String type= String.valueOf(cmbType.getValue());
        String keyMoney=txtKeyMoney.getText();
        int qty= Integer.parseInt(txtQuantity.getText());
        try {
            int save=roomBO.save(new RoomDTO(id,type,keyMoney,qty));

        }catch (Exception e){

        }

    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {
        String id=txtRoomTypeID.getText();
        String type= String.valueOf(cmbType.getValue());
        String keyMoney=txtKeyMoney.getText();
        int qty= Integer.parseInt(txtQuantity.getText());
        try {
            RoomManagementBOImpl roomBO= RoomManagementBOImpl.getInstance();
            boolean isSave=roomBO.update(new RoomDTO(id,type,keyMoney,qty));

        }catch (Exception e){

        }

    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
        String id=txtRoomTypeID.getText();
        String type= String.valueOf(cmbType.getValue());
        String keyMoney=txtKeyMoney.getText();
        int qty= Integer.parseInt(txtQuantity.getText());
        try {
            RoomManagementBOImpl roomBO= RoomManagementBOImpl.getInstance();
            boolean isSave=roomBO.delete(new RoomDTO(id,type,keyMoney,qty));

        }catch (Exception e){

        }


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cmbType.getItems().addAll(prtType);
        getAll();
        setCellValueFactory();
    }
    private void getAll()  {

        try {
            ObservableList<RoomTM> obList = FXCollections.observableArrayList();
            List<Room> cusList = roomBO.getAll();

            for (Room room : cusList) {
                obList.add(new RoomTM(
                        room.getRoomTypeId(),
                        room.getType(),
                        room.getKey_money(),
                        room.getQty()

                ));
            }
            tblRoom.refresh();
            tblRoom.setItems(obList);
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "SQL Error!").show();
        }
    }
    private void setCellValueFactory() {
        colID.setCellValueFactory(new PropertyValueFactory<>("room_type_id"));
        colType.setCellValueFactory(new PropertyValueFactory<>("type"));
        colKeyMoney.setCellValueFactory(new PropertyValueFactory<>("key_money"));
        colQuantity.setCellValueFactory(new PropertyValueFactory<>("qty"));
       // colServiceId.setCellValueFactory(new PropertyValueFactory<>("serviceID"));

    }
}
