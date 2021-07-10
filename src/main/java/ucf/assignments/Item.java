package ucf.assignments;

import java.io.Serializable;

//This will serve as an object to populate the individual lists
public class Item implements Serializable {

    //static variables, boolean isComplete, and 3 Strings: name, description, and due date.
    public boolean isComplete;
    public String description;
    public String dueDate;
    //insert appropriate getters and setters.


    public Item(boolean isComplete, String description, String dueDate) {
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

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }
}
