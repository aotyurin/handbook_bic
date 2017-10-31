package main.java;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{       
        initLayout(primaryStage);
    }

    private void initLayout(Stage primaryStage) throws java.io.IOException {
        Parent root = FXMLLoader.load(getClass().getResource("view/BaseView.fxml"));
        primaryStage.setTitle("Работа со Справочником БИК Банка России");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
