package lk.ijse.hibernate.hostalManagementSystem.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import lk.ijse.hibernate.hostalManagementSystem.bo.StudentRegistrationBOImpl;
import lk.ijse.hibernate.hostalManagementSystem.dto.StudentDTO;

public class NewStudentRegistrationFormController {

    public AnchorPane root;
    public TextField txtStudentName;
    public TextField txtStudentID;
    public TextField txtAddress;
    public TextField txtContactNo;
    public TextField txtDateOfBirth;
    public RadioButton rdbtnMale;
    public RadioButton rdbtnFemale;
    public RadioButton rdbtnOther;
    public Button btnSave;
    public Button btnUpdate;
    public Button btnDelete;

    StudentRegistrationBOImpl studentBO= StudentRegistrationBOImpl.getInstance();

    public void btnSaveOnAction(ActionEvent actionEvent) {

        String gender="";
        if(rdbtnMale.isSelected()){
            gender=rdbtnMale.getText();
        }
        else if(rdbtnFemale.isSelected()){
            gender=rdbtnFemale.getText();
        }
        else if(rdbtnOther.isSelected()){
            gender=rdbtnOther.getText();
        }

        try{
            int save=studentBO.save(new StudentDTO(txtStudentID.getText(),txtStudentName.getText(),txtAddress.getText(),txtContactNo.getText(),
                    txtDateOfBirth.getText(),gender));
        }catch (Exception e){

        }

    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {
        String gender="";
        if(rdbtnMale.isSelected()){
            gender=rdbtnMale.getText();
        }
        else if(rdbtnFemale.isSelected()){
            gender=rdbtnFemale.getText();
        }
        else if(rdbtnOther.isSelected()){
            gender=rdbtnOther.getText();
        }

        try{
            boolean isUpdate=studentBO.update(new StudentDTO(txtStudentID.getText(),txtStudentName.getText(),txtAddress.getText(),txtContactNo.getText(),
                    txtDateOfBirth.getText(),gender));
        }catch (Exception e){

        }

    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
        String gender="";
        if(rdbtnMale.isSelected()){
            gender=rdbtnMale.getText();
        }
        else if(rdbtnFemale.isSelected()){
            gender=rdbtnFemale.getText();
        }
        else if(rdbtnOther.isSelected()){
            gender=rdbtnOther.getText();
        }

        try{
            boolean isUpdate=studentBO.delete(new StudentDTO(txtStudentID.getText(),txtStudentName.getText(),txtAddress.getText(),txtContactNo.getText(),
                    txtDateOfBirth.getText(),gender));
        }catch (Exception e){

        }

    }
}
