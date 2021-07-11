/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Drake Scott
 */

package ucf.assignments;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

public class ViewSwitcher {
    //class to easily switch between scenes.

    private static Scene scene;

    //set scene function sets the view switcher scene to the scene variable.
    public static void setScene(Scene scene){
        ViewSwitcher.scene = scene;
    }

    //switcher method, with view enum parameter.
    public static void switchTo(View view){
        //if scene is null, let developer no by printing to console.
        if(scene == null){
            System.out.println("no scene set");
            return;
        }
        try {
            //set the parent root to load the filename of desired view.
            Parent root = FXMLLoader.load(ViewSwitcher.class.getResource(view.getFileName()));
            //set the root of the scene to the desired view.
            scene.setRoot(root);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
