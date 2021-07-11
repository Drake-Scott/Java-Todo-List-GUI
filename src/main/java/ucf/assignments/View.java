package ucf.assignments;

public enum View {
    LIST("List.fxml"),
    HELP("Help.fxml");


    private String fileName;

    View(String fileName){
        this.fileName = fileName;
    }

    public String getFileName(){
        return fileName;
    }

}
