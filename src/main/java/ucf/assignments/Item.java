package ucf.assignments;

import javafx.scene.control.CheckBox;

import java.io.Serializable;

//This will serve as an object to populate the individual lists
public class Item implements Serializable {

    //static variables, boolean isComplete, and 3 Strings: name, description, and due date.
    public boolean isComplete;
    public String description;
    public String dueDate;
    private CheckBox select;
    //insert appropriate getters and setters.


    public Item(boolean isComplete, String description, String dueDate) {
        this.isComplete = isComplete;
        this.description = description;
        this.dueDate = dueDate;
        this.select = new CheckBox();
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

    public CheckBox getSelect() {
        return select;
    }

    public void setSelect(CheckBox select) {
        this.select = select;
    }
}
