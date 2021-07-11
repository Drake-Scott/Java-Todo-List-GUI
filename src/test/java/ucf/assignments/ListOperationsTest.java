package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ListOperationsTest {

    //create a static list operations class.
    static ListOperations lo = new ListOperations();
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

    public static void populateOnlyFalse(){
        //create a dummy list with random variables, with only 2 incomplete items.
        Item item1 = new Item(false, "enter this cosmic realm", LocalDate.of(1999,12,21));
        Item item3 = new Item(false, "jump off cliff", LocalDate.of(2021,07,10));
        todolist.add(item1);
        todolist.add(item3);
    }

    @Test
    void onlyCompleted() {
        //populate the test list
        populateTestLists();
        //create a new observable list that will act as the return value.
        ObservableList<Item> obsList = FXCollections.observableArrayList(todolist);
        ObservableList<Item> completeSortList = lo.onlyCompleted(obsList);
        emptyTestList();

        assertEquals(completeSortList.size(), 1);
    }

    @Test
    void onlyCompleted2() {
        //populate the test list
        populateOnlyFalse();
        //create a new observable list that will act as the return value.
        ObservableList<Item> obsList = FXCollections.observableArrayList(todolist);
        ObservableList<Item> completeSortList = lo.onlyCompleted(obsList);
        emptyTestList();

        assertEquals(completeSortList.size(), 0);
    }

    @Test
    void onlyIncomplete() {
        populateTestLists();
        //create a new observable list that will act as the return value.
        ObservableList<Item> obsList = FXCollections.observableArrayList(todolist);
        ObservableList<Item> incompleteSortList = lo.onlyIncomplete(obsList);
        emptyTestList();

        assertEquals(incompleteSortList.size(), 2);
    }

    @Test
    void onlyIncomplete2() {
        populateOnlyFalse();
        //create a new observable list that will act as the return value.
        ObservableList<Item> obsList = FXCollections.observableArrayList(todolist);
        ObservableList<Item> incompleteSortList = lo.onlyIncomplete(obsList);


        assertEquals(incompleteSortList.size(), obsList.size());
        emptyTestList();
    }
}