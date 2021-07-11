/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Drake Scott
 */

package ucf.assignments;

import java.io.Serializable;
import java.time.LocalDate;

//This will serve as an object to populate the individual lists
public class Item implements Serializable {

    //static variables, boolean isComplete, String description, and a local date for due date.
    public boolean isComplete;
    public String description;
    public LocalDate dueDate;

    //insert appropriate constructor
    public Item(boolean isComplete, String description, LocalDate dueDate) {
        this.isComplete = isComplete;
        this.description = description;
        this.dueDate = dueDate;
    }

    //insert all appropriate getters and setters.
    public boolean isComplete() {
        return isComplete;
    }

    public void setComplete(boolean complete) {
        isComplete = complete;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    //override the toString method to display what we want in the listView.
    @Override
    public String toString(){
        //conditional starting phrase in string is set to nothing.
        String conditional = "";
        //if boolean for isComplete is true:
        if (isComplete){
            //display to user that the item is completed.
            conditional = "COMPLETED --- ";
        }

        //put together and return the output string from the item's information
        String output = conditional + getDueDate() + " --- " + getDescription();

        return output;
    }
}
