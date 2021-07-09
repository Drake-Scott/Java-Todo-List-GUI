package ucf.assignments;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ListOperationsTest {
    //create new list operations
    //create a new items with both complete, incomplete, and different dates UNSORTED.
    //add the items to a new list.

    @Test
    void sortListByDate() {
        //make a new list from sorting the previous list by date
        //assert that the first index date is lower than some of the later index's date.
    }

    @Test
    void onlyCompleted() {
        //make a new list with only the completed items
        //go through that list and assert that there is never an incomplete item
    }

    @Test
    void onlyIncomplete() {
        //make a new list with only the incompleted items
        //go through that list and assert that there is never a complete item
    }

    @Test
    void addItem() {
        //make a new item, add it to the list
        //assert that item is in the list
    }

    @Test
    void removeItem() {
        //remove an item from the list
        //got through the list and assert that item never shows up.
    }
}