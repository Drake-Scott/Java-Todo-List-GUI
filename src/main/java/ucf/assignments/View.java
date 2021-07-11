/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Drake Scott
 */

package ucf.assignments;

public enum View {

    //enum for both scenes.
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
