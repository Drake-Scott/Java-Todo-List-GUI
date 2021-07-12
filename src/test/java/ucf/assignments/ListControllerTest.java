package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ListControllerTest {

    @FXML
    Button AddItemButton;
    @FXML
    Button RemoveButton;
    @FXML
    Button DeleteAllButton;
    @FXML
    CheckBox CompleteBox;
    static Item currentItem;

    //create a static list controller class.
    static List<Item> todolist = new ArrayList<>();

    public static void populateTestLists(){
        //create a dummy list with random variables, 1 complete, 2 incomplete.
        Item item1 = new Item(false, "enter this cosmic realm", LocalDate.of(1999,12,21));
        Item item2 = new Item(true, "eat grass", LocalDate.of(2069,04,20));
        Item item3 = new Item(false, "jump off cliff", LocalDate.of(2021,07,10));
        todolist.add(item1);
        todolist.add(item2);
        todolist.add(item3);
    }

    public static void emptyTestList(){
        for(int i = 0; i < todolist.size(); i++){
            todolist.remove(i);
        }
    }

    @Test
    void addItemClicked() {
        emptyTestList();
        populateTestLists();
        ObservableList<Item> obsList = FXCollections.observableArrayList(todolist);
        String description = "test description";
        LocalDate dueDate = LocalDate.of(1999,12,21);
        //create a new, incomplete item using desired information
        Item newItem = new Item(false, description, dueDate);
        //add that item to the observable list
        obsList.add(newItem);

        assertEquals(obsList.size(),(todolist.size() + 1));
    }

    @Test
    void completeClicked() {
        emptyTestList();
        populateTestLists();
        ObservableList<Item> obsList = FXCollections.observableArrayList(todolist);
        Item temp = new Item(false, "enter this cosmic realm", LocalDate.of(1999,12,21));
        if(temp != null) {
            //if item is complete, set the temp's completion to false.
            if (temp.isComplete()) {
                temp.setComplete(false);
                //if the current item is incomplete, set temp's completion to true.
            } else if (!temp.isComplete()) {
                temp.setComplete(true);
            }
        }
        assertTrue(temp.isComplete());
    }

    @Test
    void completeClicked2() {
        emptyTestList();
        populateTestLists();
        ObservableList<Item> obsList = FXCollections.observableArrayList(todolist);
        Item temp = new Item(true, "eat grass", LocalDate.of(2069,04,20));
        if(temp != null) {
            //if item is complete, set the temp's completion to false.
            if (temp.isComplete()) {
                temp.setComplete(false);
                //if the current item is incomplete, set temp's completion to true.
            } else if (!temp.isComplete()) {
                temp.setComplete(true);
            }
        }
        assertFalse(temp.isComplete());
    }

    @Test
    void deleteAll() {
        emptyTestList();
        populateTestLists();
        ObservableList<Item> obsList = FXCollections.observableArrayList(todolist);
        emptyTestList();
        obsList.setAll();
        assertEquals(obsList.size(),0);
    }
}