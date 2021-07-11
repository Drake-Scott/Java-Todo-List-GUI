/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Drake Scott
 */

package ucf.assignments;

import java.io.Serializable;
import java.time.LocalDate;

//This will serve as an object to populate the individual lists
public class Item implements Serializable {

    //static variables, boolean isComplete, and 3 Strings: name, description, and due date.
    public boolean isComplete;
    public String description;
    public LocalDate dueDate;
    //insert appropriate getters and setters.


    public Item(boolean isComplete, String description, LocalDate dueDate) {
        this.isComplete = isComplete;
        this.description = description;
        this.dueDate = dueDate;
    }

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

    @Override
    public String toString(){
        String conditional = "";
        if (isComplete){
            conditional = "COMPLETED --- ";
        }

        String output = conditional + getDueDate() + " --- " + getDescription();

        return output;
    }
}
