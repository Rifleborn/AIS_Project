package classes;

import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import java.sql.SQLException;

public class Main extends Application{
   
    // menu window
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Проектування АІС");
        primaryStage.setScene(new Scene (root, 777, 535));
        primaryStage.show();
  }

    public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, SQLException{

    // dbHandler.WriteDB();
    // delete this
    launch(args);
    }
}
