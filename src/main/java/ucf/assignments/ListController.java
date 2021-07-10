package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ListController {

    public static ListOperations lo = new ListOperations();
    public static FileOperations fo = new FileOperations();
    public static NewItemController nic = new NewItemController();
    public static FileChooser fc = new FileChooser();

    public static List<Item> todoList = new ArrayList<>();

    @FXML
    TableView ListTable;
    @FXML
    TableColumn SelectCol;
    @FXML
    TableColumn CompleteCol;
    @FXML
    TableColumn DateCol;
    @FXML
    TableColumn TaskCol;
    @FXML
    Button AddItemButton;
    @FXML
    Button RemoveButton;
    @FXML
    Button SaveButton;
    @FXML
    CheckBox CompleteBox;
    @FXML
    CheckBox IncompleteBox;
    @FXML
    Button DeleteAllButton;
    @FXML
    Button LoadListButton;

    @FXML
    public void initialize(URL url, ResourceBundle rb){
        final ObservableList<Item> data = FXCollections.observableList(todoList);
        CompleteCol.setCellValueFactory(new PropertyValueFactory<Item, Boolean>("isComplete"));
    }

    @FXML
    public void AddItemClicked(ActionEvent actionEvent) {
        ViewSwitcher.switchTo(View.NEWITEM);
    }

    @FXML
    public void RemoveClicked(ActionEvent actionEvent) {
    }

    @FXML
    public void SaveClicked(ActionEvent actionEvent) {
        fc.setTitle("Save Dialog");
        fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("text file", "*.txt"));
        try{
            File file = fc.showSaveDialog(null);
            fc.setInitialDirectory(file.getParentFile()); //saves previous chosen directory for saving the lists.

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    public void CompleteOn(ActionEvent actionEvent) {
    }

    @FXML
    public void IncompleteOn(ActionEvent actionEvent) {
    }

    @FXML
    public void DeleteAll(ActionEvent actionEvent) {
    }

    @FXML
    public void LoadListClicked(ActionEvent actionEvent) {

        fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("text file", "*.txt"));
        fc.setTitle("Choose Text File");
        try {
            File selectedFile = fc.showOpenDialog(null);
            todoList = fo.deserializeList(selectedFile);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
