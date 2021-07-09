package ucf.assignments;

import java.util.List;

public class FileOperations {

    /*
    PLAN: I will have a File master.txt that contains the name of every list that has been created.
    This can act like keys to a hashmap with the values being the to do lists. Map<String, List<Item>>;
    I will have a directory that contains text files, each of them named after a to do list within the master list.
    when the user wants to load a list it will populate the list from the formatted text file within the directory.
    when the user wants to add a list it will create a new textfile within the directory, and add its name to master.txt
    */

    //see exercise 41 for help.

    public static List populateList(){
        //when the client loads a list, this function is called to create that list from external storage
        return null;
    }

    public void addKeyToMaster(){
        //when a user creates a new list, what they type as the title will become the key that links to that list
        //this program will open up the master.txt file and add the string to it
    }

    public void deleteListFromDirectory(){
        //this function is called in the function below
        //searches for .txt file named after key String user typed in
        //deletes that file
    }

    public void removeListFromMaster(){
        //when user wants to delete a list this function runs
        //opens the master.txt file and removes the String inputted by the user.
        //remove the key and value from the hashmap.
        //calls the deleteListFromDirectory() method.
    }



}
