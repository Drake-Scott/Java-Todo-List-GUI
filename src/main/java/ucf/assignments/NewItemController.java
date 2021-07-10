package ucf.assignments;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


public class NewItemController {

    @FXML
    TextArea DescriptionBox;
    @FXML
    TextField YearField;
    @FXML
    TextField MonthField;
    @FXML
    TextField DayField;

    public Item FinalizeClicked(ActionEvent actionEvent) {
        String description = DescriptionBox.getText();
        String year = YearField.getText();
        String month = MonthField.getText();
        String day = DayField.getText();
        String dueDate = year+"-"+month+"-"+day;
        Item newItem = new Item(false, description, dueDate);

        //go back to the list view
        ViewSwitcher.switchTo(View.LIST);
        //return the new item from the user input
        return newItem;
    }
}
