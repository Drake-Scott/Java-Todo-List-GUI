package ucf.assignments;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ListControllerTest {

    //create a static list operations class.
    static ListController lc = new ListController();
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
    }

    @Test
    void removeClicked() {
    }

    @Test
    void completeClicked() {
    }

    @Test
    void deleteAll() {
    }
}