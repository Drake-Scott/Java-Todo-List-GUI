/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Drake Scott
 */

package ucf.assignments;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        try {
            Parent root = FXMLLoader.load(getClass().getResource("List.fxml"));
            Scene scene = new Scene(root);
            ViewSwitcher.setScene(scene);
            ViewSwitcher.switchTo(View.LIST);

            primaryStage.setScene(scene);
            primaryStage.setTitle("To-Do List");
            primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
