/*
*  UCF COP3330 Summer 2021 Assignment 4 Solution
*  Copyright 2021 Drake Scott
*/

package ucf.assignments;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class HelpController implements Initializable {

    @FXML
    private ImageView imageView;


    public void BackClicked(ActionEvent actionEvent) {
        ViewSwitcher.switchTo(View.LIST);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Image img = new Image("file:images/HelpScreen.png");
        imageView.setImage(img);
    }
}
