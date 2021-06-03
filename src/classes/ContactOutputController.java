package classes;

import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import java.io.File;
import java.net.URL;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import java.awt.MouseInfo;
import java.util.Scanner;
import javafx.scene.control.TextArea;

public class ContactOutputController {

    private String contact_name;
    private String contact_surname;
    private String contact_address;
    private int contact_id;

    public ArrayList<Contact> contacts = new ArrayList<>();
    public static TextArea contactsOutput;

    public void createWindow() throws Exception {

        Stage ContactWindow = new Stage();

        Parent root = FXMLLoader.load(getClass().getResource("contactsOutput.fxml"));
        ContactWindow.setTitle("Ввід з файлу");
        ContactWindow.setScene(new Scene (root, 600, 500));

        ContactWindow.initModality(Modality.WINDOW_MODAL);

        ContactWindow.setX(MouseInfo.getPointerInfo().getLocation().x - 150);
        ContactWindow.setY(MouseInfo.getPointerInfo().getLocation().y - 150);
        initData();
        ContactWindow.show();

    }

    public void initData() throws Exception {
        File file = new File("inputContacts.txt");

        Scanner sc = new Scanner(file);

        while (sc.hasNext()) {
            contact_id = Integer.parseInt(sc.nextLine());
            contact_name = sc.nextLine();
            contact_surname = sc.nextLine();
            contact_address = sc.nextLine();
            contacts.add(new Contact(contact_id, contact_name, contact_surname, contact_address));
            if (contact_name == ""){
                break;
            }
        }
        System.out.println("Колекція перед вводом в лейбл");
        contacts.stream().forEach(System.out::print);

        contactsOutput.setText(contacts.toString());
        sc.close();

    }

}

