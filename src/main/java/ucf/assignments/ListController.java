package ucf.assignments;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.FileChooser;

import javax.swing.text.TableView;
import java.io.File;
import java.util.List;

public class ListController {

    ListOperations lo = new ListOperations();

    public void AddItemClicked(ActionEvent actionEvent) {
        ViewSwitcher.switchTo(View.NEWITEM);

    }

    public void RemoveClicked(ActionEvent actionEvent) {
    }

    public void SaveClicked(ActionEvent actionEvent) {
    }

    public void CompleteOn(ActionEvent actionEvent) {
    }

    public void IncompleteOn(ActionEvent actionEvent) {
    }

    public void DeleteAll(ActionEvent actionEvent) {
    }

    public void LoadListClicked(ActionEvent actionEvent) {
        FileChooser fc = new FileChooser();
        File selectedFile = fc.showOpenDialog(null);
        if (selectedFile != null){
        } else {

        }
    }
}
