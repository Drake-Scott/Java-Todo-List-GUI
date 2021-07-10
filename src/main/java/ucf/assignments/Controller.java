package ucf.assignments;

import javafx.event.ActionEvent;

public class Controller {
    public void CreateListClicked(ActionEvent actionEvent) {
        ViewSwitcher.switchTo(View.LIST);
    }

    public void LoadListClicked(ActionEvent actionEvent) {
        ViewSwitcher.switchTo(View.LIST);
    }

    public void HelpClicked(ActionEvent actionEvent) {
    }
}
