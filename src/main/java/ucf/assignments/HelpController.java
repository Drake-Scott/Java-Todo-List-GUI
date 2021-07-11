/*
*  UCF COP3330 Summer 2021 Assignment 4 Solution
*  Copyright 2021 Drake Scott
*/

package ucf.assignments;
import javafx.event.ActionEvent;

public class HelpController {

    //this scene shows an image that helps user operate the application
    //if the back button is clicked, switch back to the view of the list scene.
    public void BackClicked(ActionEvent actionEvent) {
        ViewSwitcher.switchTo(View.LIST);
    }

}
