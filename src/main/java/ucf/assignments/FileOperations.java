package ucf.assignments;

import com.google.gson.Gson;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class FileOperations {
    public static Gson gson = new Gson();
    //see exercise 41 for help.

    /*
    public static List<Item> populateListFromJson(String filePath){

        File input = new File(filePath);
        List<Item> todoList = new ArrayList<>();

        try {
            //User Gson to parse elements into Product object.
            JsonElement fileElement = JsonParser.parseReader(new FileReader(input));
            JsonObject fileObject = fileElement.getAsJsonObject();

            //Extract the data from Json file to appropriate data types.
            JsonArray arrayOfItems = fileObject.get("items").getAsJsonArray();

            //Iterate through each element of the Json file.
            for (JsonElement itemElement : arrayOfItems){

                //Create Json Object using Gson
                JsonObject itemJsonObject = itemElement.getAsJsonObject();

                //For each element of the Json file, get the name, price, and quantity.
                boolean isComplete = itemJsonObject.get("isComplete").getAsBoolean();
                String description = itemJsonObject.get("description").getAsString();
                String dueDate = itemJsonObject.get("dueDate").getAsString();

                //create a new product with the previous information and add it to the list
                Item item = new Item(isComplete, description, dueDate);
                todoList.add(item);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return todoList;
    }*/



    public void serializeList(String filePath, List<Item> todoList) throws Exception{
        FileOutputStream fos = new FileOutputStream(filePath);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(todoList);
        oos.close();
        fos.close();
    }

    public List<Item> deserializeList(String filePath) throws Exception{
        List<Item> todoList = new ArrayList<>();

        FileInputStream fis = new FileInputStream(filePath);
        ObjectInputStream ois = new ObjectInputStream(fis);

        todoList = (List<Item>) ois.readObject();

        ois.close();
        fis.close();

        return todoList;
    }

}
