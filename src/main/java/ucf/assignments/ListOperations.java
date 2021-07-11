package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ListOperations {


    public ObservableList<Item> onlyCompleted(ObservableList<Item> ToDoList){
        //go through the ToDoList, and add all completed Items to a new list
        //init. new array list CompletedList of items.
        ObservableList<Item> CompleteSort = FXCollections.observableArrayList();
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

    public ObservableList<Item> onlyIncomplete(ObservableList<Item> ToDoList){
        //go through the ToDoList, and add all incomplete Items to a new list
        //init. new array list IncompleteList of items.
        ObservableList<Item> IncompleteSort = FXCollections.observableArrayList();
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

}
