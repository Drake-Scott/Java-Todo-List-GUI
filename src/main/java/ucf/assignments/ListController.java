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

    //create static variables for list operations, file operations, and a file chooser.
    public static ListOperations lo = new ListOperations();
    public static FileOperations fo = new FileOperations();
    public static FileChooser fc = new FileChooser();

    //create variables for an array list and the observable list that will be displayed in the application.
    public static List<Item> todoList = new ArrayList<>();
    public ObservableList<Item> obsList = FXCollections.observableArrayList(todoList);
    //set static variables for current selected item, and whether or not the list has been saved.
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

    //declare all FXML elements.
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
        //if either entry fields for a new item are invalid, dont allow user to input item.
        if(DescriptionBox.getText() == "" || datePicker.getValue() == null ||
        DescriptionBox.getText().length() >= 256){
            //send an error alert that user must enter more information before inputting a task.
            Alert completeAlert = new Alert(Alert.AlertType.ERROR);
            completeAlert.setHeaderText("Invalid Entry");
            completeAlert.setContentText("Please enter date and description no longer\nthan 256 characters");
            completeAlert.showAndWait();
        }
        else {
            //populate description and date variables from appropriate nodes on GUI
            String description = DescriptionBox.getText();
            LocalDate dueDate = datePicker.getValue();
            //create a new, incomplete item using desired information
            Item newItem = new Item(false, description, dueDate);
            //add that item to the observable list
            obsList.add(newItem);
            //update the listview.
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
        //set up file chooser to save a text file.
        fc.setTitle("Save Dialog");
        fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("text file", "*.txt"));
        try{
            //create a new array list for serializing from the observable list
            List<Item> serializerList = new ArrayList<>();
            //iterate through every item in the observable list
            for(int i = 0; i < obsList.size(); i++){
                //add each item to the serializer list.
                serializerList.add(obsList.get(i));
            }
            //show the file chooser save window.
            File file = fc.showSaveDialog(null);
            //set initial directory so anytime a filechooser opens it starts here.
            fc.setInitialDirectory(file.getParentFile()); //saves previous chosen directory for saving the lists.
            //save the serialized list to the desired file with desired info.
            fo.serializeList(file, serializerList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //set isSaved to true.
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
        //set the description box and date picker back to null.
        DescriptionBox.setText(null);
        datePicker.setValue(null);
    }

    @FXML
    public void LoadListClicked(ActionEvent actionEvent) {
        //list is loaded from file
        //set file chooser to only pick from .txt files
        fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("text file", "*.txt"));
        fc.setTitle("Choose Text File");
        try{
            //create a list that will get input from file and populate observable list
            List<Item> deserializerList = new ArrayList<>();
            File selectedFile = fc.showOpenDialog(null);
            //If selected file does not exist or no file is selected:
            if(selectedFile == null){
                //Create a new error alert
                Alert helpAlert = new Alert(Alert.AlertType.ERROR);
                helpAlert.setHeaderText("No list selected!");
                helpAlert.setContentText("select a previously saved list, or create a new one by adding \nitems");
                helpAlert.showAndWait();
            }
            else {
                //deserialize text file into the list
                deserializerList = fo.deserializeList(selectedFile);
                //populate observable list with the elements of the new list
                obsList = FXCollections.observableArrayList(deserializerList);
                //update the listview.
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
        //if the current item exists (is selected) and valid date and description are selected:
        if(currentItem != null && datePicker.getValue() != null &&
                DescriptionBox.getText().length() >= 256) {
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
            overwriteAlert.setContentText("Please select an item to change its date\nor description" +
                    " (no more than 256 characters)");
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
            //otherwise, create a new alert. going to help menu will delete the current list in app.
            Alert helpAlert = new Alert(Alert.AlertType.INFORMATION);
            helpAlert.setHeaderText("Going to the help screen deletes the current list!");
            helpAlert.setContentText("save your list with the bottom right button first!\n(or delete the items)");
            helpAlert.showAndWait();
        }
    }
}
