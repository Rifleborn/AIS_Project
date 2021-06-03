package classes;

import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.Parent;
import java.awt.MouseInfo;
import java.sql.SQLException;

public class Controller {
    
    @FXML
    private Button input_contact;

    @FXML
    private Button input_order;

    @FXML
    private Button ContactsFromFile;

    @FXML
    private Button StudentsFromFile;

    @FXML
    private Button dataFromBaseStudents;

    @FXML
    private TextArea textAreaStudents;

    @FXML
    private TextArea textAreaRooms;

    @FXML
    private TextArea textAreaPriveleges;

    @FXML
    private Button dataFromBaseRooms;

    @FXML
    private Button dataFromBasePriveleges;

    @FXML
    private Button dataToBaseStudents;

    @FXML
    private Button dataToBasePriveleges;

    @FXML
    private Button dataToBaseRooms;
    
    @FXML
    private Button dataToTableStudents;
    
    // text fields    
    @FXML
    private TextField SNP_field;

    @FXML
    private TextField birthYear_field;

    @FXML
    private TextField gender_field;

    @FXML
    private TextField group_field;

    @FXML
    private TextField privelegeCode_field;

    @FXML
    private TextField passport_field;

    @FXML
    private TextField colonizeDate_field;

    @FXML
    private TextField address_field;

    @FXML
    private TextField room_field;

    @FXML
    void handleButtonActionDataToTableStudents(ActionEvent event) throws SQLException, ClassNotFoundException {
        String SNP;
        String birthYear;
        String gender;
        String address;
        String studentGroup;
        int privelegeCode;
        String passport;
        int room;
        String colonizeDate;
        
        SNP = SNP_field.getText();
        birthYear = birthYear_field.getText();
        gender = gender_field.getText();
        address = address_field.getText();
        studentGroup = group_field.getText();
        privelegeCode = Integer.parseInt(privelegeCode_field.getText());
        passport = passport_field.getText();
        room = Integer.parseInt(room_field.getText());
        colonizeDate = colonizeDate_field.getText();
        
        // for debug
        System.out.println("SNP: " + SNP + "\n");       
        System.out.println("Birth year: " + birthYear + "\n");       
        System.out.println("Gender: " + gender + "\n");       
        System.out.println("Address: " + address + "\n");       
        System.out.println("Group: " + studentGroup + "\n");       
        System.out.println("Privelege code: " + privelegeCode + "\n");       
        System.out.println("Passport: " + passport + "\n");       
        System.out.println("Room: " + room + "\n");      
        System.out.println("Colonize date: " + colonizeDate + "\n");       
       
        
        // connection with DB and writing data
        DataBaseHandler dbHandler = new DataBaseHandler(); 
        dbHandler.Connection();
        dbHandler.CreateDB();
        dbHandler.WriteDB(address, passport, SNP, birthYear, gender, privelegeCode, studentGroup, room, colonizeDate);
        //dbHandler.CloseDB();
    }
    
    public void handleButtonActionDataFromBaseStudents (javafx.event.ActionEvent actionEvent) throws SQLException, ClassNotFoundException {     
          DataBaseHandler dbHandler = new DataBaseHandler(); 
          dbHandler.Connection();
          dbHandler.CreateDB();
          
          textAreaStudents.setWrapText(true);
          textAreaStudents.setText(dbHandler.ReadDB());
          dbHandler.CloseDB();
    }
    
    
    public void handleButtonActionInputContact(javafx.event.ActionEvent actionEvent) throws Exception{

        Stage ContactWindow = new Stage();

        Parent root = FXMLLoader.load(getClass().getResource("input_contact.fxml"));

        ContactWindow.setTitle("Введення контакту");
        ContactWindow.setScene(new Scene (root, 601, 412));


        ContactWindow.initModality(Modality.WINDOW_MODAL);

        ContactWindow.setX(MouseInfo.getPointerInfo().getLocation().x - 150);
        ContactWindow.setY(MouseInfo.getPointerInfo().getLocation().y - 150);
        ContactWindow.show();
    }

    public void handleButtonActionContactsFromFile(ActionEvent actionEvent) throws Exception {
        ContactOutputController contactOC = new ContactOutputController();
        contactOC.createWindow();
    }

    @FXML
    void handleButtonActionDataFromBasePriveleges(ActionEvent event) {

    }

    @FXML
    void handleButtonActionDataFromBaseRooms(ActionEvent event) {

    }

    @FXML
    void handleButtonActionDataToBaseRooms(ActionEvent event) {

    }

    @FXML
    void handleButtonActionDataToBaseStudents(ActionEvent event) throws Exception {
        Stage studentToBase = new Stage();

        Parent root = FXMLLoader.load(getClass().getResource("inputStudents.fxml"));
        studentToBase.setTitle("Введення даних");
        studentToBase.setScene(new Scene (root, 601, 412));
        studentToBase.initModality(Modality.WINDOW_MODAL);

        studentToBase.setX(MouseInfo.getPointerInfo().getLocation().x - 150);
        studentToBase.setY(MouseInfo.getPointerInfo().getLocation().y - 150);
        studentToBase.show();
    }

}