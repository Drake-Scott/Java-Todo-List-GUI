package ucf.assignments;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ListController implements Initializable {

    public static ListOperations lo = new ListOperations();
    public static FileOperations fo = new FileOperations();
    public static FileChooser fc = new FileChooser();

    public static List<Item> todoList = new ArrayList<>();
    public ObservableList<Item> obsList = FXCollections.observableArrayList(todoList);
    static Item currentItem;

    @Override
    public void initialize(URL url, ResourceBundle rb){
        obsList.add(new Item(true,"hello","uhhh"));
        ListTable.setItems(obsList);
        ListTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Item>() {
            //When you select an item from the list view, this sets current item variable to that item.
            @Override
            public void changed(ObservableValue<? extends Item> observable, Item oldValue, Item newValue) {
                currentItem = ListTable.getSelectionModel().getSelectedItem();
            }
        });
    }

    @FXML
    ListView<Item> ListTable;
    @FXML
    TextField YearSelect;
    @FXML
    TextField MonthSelect;
    @FXML
    TextField DaySelect;
    @FXML
    TextField DescriptionBox;
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
    public void AddItemClicked(ActionEvent actionEvent) {
        String description = DescriptionBox.getText();
        String year = YearSelect.getText();
        String month = MonthSelect.getText();
        String day = DaySelect.getText();
        String dueDate = year+"-"+month+"-"+day;
        Item newItem = new Item(false, description, dueDate);
        obsList.add(newItem);
        ListTable.setItems(obsList);
    }

    @FXML
    public void RemoveClicked(ActionEvent actionEvent) {
        Item itemToRemove = currentItem;
        int selectedIndex = 0;
        //iterate through the observable list
        for(Item item : obsList){
            //if the object equals the object we wish to remove, note the index.
            if(item == itemToRemove){
                selectedIndex = obsList.indexOf(item);
            }
        }
        obsList.remove(selectedIndex);
    }

    @FXML
    public void CompleteClicked(ActionEvent actionEvent) {
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
        //If the checkbox for incomplete sort is on,
        if (IncompleteBox.isSelected()) {
            //turn it off.
            IncompleteBox.setSelected(false);
        }


    }

    @FXML
    public void IncompleteOn(ActionEvent actionEvent) {
        //If the checkbox for complete sort is on,
        if (CompleteBox.isSelected()) {
            //turn it off.
            CompleteBox.setSelected(false);
        }

    }

    @FXML
    public void DeleteAll(ActionEvent actionEvent) {
        //set the entire list to be empty.
        obsList.setAll();
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

    public void BackClicked(ActionEvent actionEvent) {
        ViewSwitcher.switchTo(View.APP);
    }


}
