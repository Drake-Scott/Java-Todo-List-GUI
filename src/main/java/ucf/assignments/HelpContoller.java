package ucf.assignments;

import javafx.event.ActionEvent;

public class HelpContoller {
    public void BackClicked(ActionEvent actionEvent) {
        ViewSwitcher.switchTo(View.LIST);
    }
}
