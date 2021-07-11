package ucf.assignments;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileOperations {

    //Method to serialize a list to a text file at the desired file path.
    public void serializeList(File filePath, List<Item> todoList){
        try {

            //create file and object output streams because my object class implements serializable
            FileOutputStream fos = new FileOutputStream(filePath);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            //write the list of objects to the output file using object output stream.
            oos.writeObject(todoList);

            //close the object and file output streams
            oos.close();
            fos.close();

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<Item> deserializeList(File filePath){

        //initialize an empty list of items that will serve as our return list.
        List<Item> todoList = new ArrayList<>();

        try {

            //create file and object input streams because my object class implements serializable
            FileInputStream fis = new FileInputStream(filePath);
            ObjectInputStream ois = new ObjectInputStream(fis);

            //populate the todolist from the object input stream.
            todoList = (List<Item>) ois.readObject();

            //close the object and file input streams
            ois.close();
            fis.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        //return the now populated todolist
        return todoList;
    }

}
