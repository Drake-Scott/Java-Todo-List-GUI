/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Drake Scott
 */

package ucf.assignments;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.FileChooser;

import java.io.File;
import java.net.URL;
import java.time.LocalDate;
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
    static boolean isSaved;

    @Override
    public void initialize(URL url, ResourceBundle rb){
        //obsList.add(new Item(true,"hello", LocalDate.of(1999,12,21)));
        ListTable.setItems(obsList);
        ListTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Item>() {
            //When you select an item from the list view, this sets current item variable to that item.
            @Override
            public void changed(ObservableValue<? extends Item> observable, Item oldValue, Item newValue) {
                currentItem = ListTable.getSelectionModel().getSelectedItem();
                //if the current selected item exists:
                if(currentItem != null) {
                    //set the date picker to the current item's due date
                    datePicker.setValue(currentItem.getDueDate());
                    //set the description box to the current item's description
                    DescriptionBox.setText(currentItem.getDescription());
                    //If the selected item is completed, set the completion checkbox to true.
                    if (currentItem.isComplete()) {
                        CompleteSelection.setSelected(true);
                    }
                    //otherwise set it to false.
                    else {
                        CompleteSelection.setSelected(false);
                    }
                }
            }
        });
    }


    @FXML
    ListView<Item> ListTable;
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
    CheckBox CompleteSelection;
    @FXML
    Button DeleteAllButton;
    @FXML
    Button LoadListButton;
    @FXML
    DatePicker datePicker;

    @FXML
    public void AddItemClicked(ActionEvent actionEvent) {
        isSaved = false;
        if(DescriptionBox.getText() == "" || datePicker.getValue() == null){
            Alert completeAlert = new Alert(Alert.AlertType.ERROR);
            completeAlert.setHeaderText("Invalid Entry");
            completeAlert.setContentText("Please enter date and description");
            completeAlert.showAndWait();
        }
        else {
            String description = DescriptionBox.getText();
            LocalDate dueDate = datePicker.getValue();
            Item newItem = new Item(false, description, dueDate);
            obsList.add(newItem);
            ListTable.setItems(obsList);
        }
    }

    @FXML
    public void RemoveClicked(ActionEvent actionEvent) {
        isSaved = false;
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
        isSaved = false;
        //create a temporary item that will replace the current item with differing boolean completion.
        Item temp = currentItem;
        //if the current item exists (is selected):
        if(currentItem != null) {
            //if item is complete, set the temp's completion to false.
            if (currentItem.isComplete()) {
                temp.setComplete(false);
                //if the current item is incomplete, set temp's completion to true.
            } else if (!currentItem.isComplete()) {
                temp.setComplete(true);
            }
        }
        //if the current item does not exist
        else{
            //create and display an appropriate alert message
            Alert completeAlert = new Alert(Alert.AlertType.ERROR);
            completeAlert.setHeaderText("Invalid Selection");
            completeAlert.setContentText("Please select an item.");
            completeAlert.showAndWait();
            //set the box to be empty.
            CompleteSelection.setSelected(false);
        }
        //save the index of current item to integer variable.
        int idx = obsList.indexOf(currentItem);
        //remove the current item from observable list
        obsList.remove(currentItem);
        //add the temp item at the appropriate index
        obsList.add(idx, temp);
        //reset the listview
        ListTable.setItems(obsList);
    }

    @FXML
    public void SaveClicked(ActionEvent actionEvent) {
        fc.setTitle("Save Dialog");
        fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("text file", "*.txt"));
        try{
            List<Item> serializerList = new ArrayList<>();
            for(int i = 0; i < obsList.size(); i++){
                serializerList.add(obsList.get(i));
            }
            File file = fc.showSaveDialog(null);
            fc.setInitialDirectory(file.getParentFile()); //saves previous chosen directory for saving the lists.
            fo.serializeList(file, serializerList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        isSaved = true;
    }

    @FXML
    public void CompleteOn(ActionEvent actionEvent) {
        //If the checkbox for incomplete sort is on,
        if (IncompleteBox.isSelected()) {
            //turn it off.
            IncompleteBox.setSelected(false);
        }
        //if the box is switched to be checked on:
        if(CompleteBox.isSelected()){
            //create a new sorted list from the list operations onlyCompleted() function.
            ObservableList<Item> CompleteSort = lo.onlyCompleted(obsList);
            //set the list table to display only those items.
            ListTable.setItems(CompleteSort);
        }
        //if the box is switched to be checked off
        else{
            //set the list table to the original observable list.
            ListTable.setItems(obsList);
        }

    }

    @FXML
    public void IncompleteOn(ActionEvent actionEvent) {
        //If the checkbox for complete sort is on,
        if (CompleteBox.isSelected()) {
            //turn it off.
            CompleteBox.setSelected(false);
        }
        //if the box is switched to be checked on:
        if(IncompleteBox.isSelected()){
            //create a new sorted list from the list operations onlyCompleted() function.
            ObservableList<Item> IncompleteSort = lo.onlyIncomplete(obsList);
            //set the list table to display only those items.
            ListTable.setItems(IncompleteSort);
        }
        //if the box is switched to be checked off
        else{
            //set the list table to the original observable list.
            ListTable.setItems(obsList);
        }
    }

    @FXML
    public void DeleteAll(ActionEvent actionEvent) {
        isSaved = false;
        //set the entire list to be empty.
        obsList.setAll();
        //reset the listview
        ListTable.setItems(obsList);
        DescriptionBox.setText(null);
        datePicker.setValue(null);
    }

    @FXML
    public void LoadListClicked(ActionEvent actionEvent) {
        fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("text file", "*.txt"));
        fc.setTitle("Choose Text File");
        try{
            List<Item> deserializerList = new ArrayList<>();
            File selectedFile = fc.showOpenDialog(null);
            if(selectedFile == null){
                Alert helpAlert = new Alert(Alert.AlertType.ERROR);
                helpAlert.setHeaderText("No list selected!");
                helpAlert.setContentText("select a previously saved list, or create a new one by adding \nitems");
                helpAlert.showAndWait();
            }
            else {
                deserializerList = fo.deserializeList(selectedFile);
                obsList = FXCollections.observableArrayList(deserializerList);
                ListTable.setItems(obsList);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    public void OverwriteClicked(ActionEvent actionEvent) {
        isSaved = false;
        //create a temporary item that will replace the current item with differing date and/or description
        Item temp = currentItem;
        //if the current item exists (is selected):
        if(currentItem != null) {
            //keep the completion status static
            temp.setComplete(currentItem.isComplete());
            //set the date and description to whatever is present in the corresponding nodes.
            temp.setDueDate(datePicker.getValue());
            temp.setDescription(DescriptionBox.getText());
        }
        //if the current item does not exist
        else{
            //create and display an appropriate alert message
            Alert overwriteAlert = new Alert(Alert.AlertType.ERROR);
            overwriteAlert.setHeaderText("Invalid Selection");
            overwriteAlert.setContentText("Please select an item.");
            overwriteAlert.showAndWait();
        }
        //save the index of current item to integer variable.
        int idx = obsList.indexOf(currentItem);
        //remove the current item from observable list
        obsList.remove(currentItem);
        //add the temp item at the appropriate index
        obsList.add(idx, temp);
        //reset the listview
        ListTable.setItems(obsList);
    }

    @FXML
    public void HelpButtonClicked(ActionEvent actionEvent) {
        //if the list is not empty, or the last action was to save it:
        if(obsList.size() == 0 || isSaved == true){
            //switch the view to help
            ViewSwitcher.switchTo(View.HELP);
        } else {
            Alert helpAlert = new Alert(Alert.AlertType.INFORMATION);
            helpAlert.setHeaderText("Going to the help screen deletes the current list!");
            helpAlert.setContentText("save your list with the bottom right button first!\n(or delete the items)");
            helpAlert.showAndWait();
        }
    }
}
