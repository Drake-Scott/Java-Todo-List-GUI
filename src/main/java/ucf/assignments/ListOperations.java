package ucf.assignments;

import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class ListOperations {


    public List<Item> onlyCompleted(ObservableList<Item> ToDoList){
        //go through the ToDoList, and add all completed Items to a new list
        //init. new array list CompletedList of items.
        List<Item> CompleteSort = new ArrayList<>();
        //iterate through initial to do list.
        for(Item item : ToDoList){
            //completed items have true for boolean value
            if(item.isComplete()){
                //if the item is COMPLETE add it to new completedList
                CompleteSort.add(item);
            }
        }
        //return the list of only completed items
        return CompleteSort;
    }

    public List<Item> onlyIncomplete(ObservableList<Item> ToDoList){
        //go through the ToDoList, and add all incomplete Items to a new list
        //init. new array list IncompleteList of items.
        List<Item> IncompleteSort = new ArrayList<>();
        //iterate through initial to do list.
        for(Item item : ToDoList){
            //incomplete items have false for boolean value
            if(!item.isComplete()){
                //if the item is INCOMPLETE add it to new incompleteList
                IncompleteSort.add(item);
            }
        }
        //return the list of only incomplete items
        return IncompleteSort;
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
