package ucf.assignments;

public enum View {
    APP("App.fxml"),
    LIST("List.fxml"),
    NEWITEM("NewItem.fxml");

    private String fileName;

    View(String fileName){
        this.fileName = fileName;
    }

    public String getFileName(){
        return fileName;
    }

}
