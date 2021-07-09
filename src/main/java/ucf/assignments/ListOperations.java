package ucf.assignments;

import java.util.ArrayList;
import java.util.List;

public class ListOperations {

    public static List<Item> createNewList(){
        //initialize a new array list with objects
        //add it to the hash map
        return null;
    }

    //This particular function is extra credit
    public List<Item> sortListByDate(List<Item> ToDoList){
        //use comparator collection.
        return null;
    }

    public List<Item> onlyCompleted(List<Item> ToDoList){
        //go through the ToDoList, and add all completed Items to a new list
        //init. new array list CompletedList of items.
        //iterate thru initial to do list.
        //completed items have true for boolean value
        //if the item is COMPLETE add it to new completedList
        return null;
    }

    public List<Item> onlyIncomplete(List<Item> ToDoList){
        //go through the ToDoList, and add all incomplete Items to a new list
        //init. new array list of items IncompletedList
        //iterate through initial to do list
        //incomplete items have false for boolean value.
        //if the item is INCOMPLETE add it to new IncompletedList
        return null;
    }

    public List<Item> addItem(List<Item> ToDoList, boolean isComplete, String Name, String date, String description){
        //this function is ran when user clicks final add item button on the inputItem scene
        //add newItem to the ToDoList
        //new item's attributes are what use typed into the text fields.
        return null;
    }

    public List<Item> removeItem(List<Item> ToDoList, Item itemToBeRemoved){
        //remove itemToBeRemoved from the ToDoList
        return null;
    }

}
