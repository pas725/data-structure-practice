package misc.serialization;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by psagar on 3/1/2018.
 */
public class SerializeDe {
    public static void main(String[] args) {
        Map<Integer, Item> hashMap = new HashMap<>();
        hashMap.put(1, new Item(1, "john"));
        hashMap.put(2, new Item(2, "cena"));
        hashMap.put(3, new Item(3, "test"));

        String fileName = "{ff}";
        String arr[] = fileName.split("\\{");
        String staticKey = arr[0];
        String dynamicKey = arr[1].split("\\}")[0];
        System.out.println("1 : "+ staticKey + ", 2 : "+ dynamicKey);
        //serialize(hashMap, fileName);[0
        //Map<Integer, Item> res = deSerialize(fileName);
        System.out.println( Integer.valueOf(5) instanceof Number);

        //System.out.println(res);

    }

    static void serialize(Map<Integer, Item> hashMap, String fileName) {
        try {
            FileOutputStream outputStream = new FileOutputStream(fileName);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(hashMap);
            objectOutputStream.close();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static Map<Integer, Item> deSerialize(String name) {

        try {
            FileInputStream inputStream = new FileInputStream(name);
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            Object res = objectInputStream.readObject();
            return (HashMap.class.cast(res));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }



}

class Item implements Serializable{
    private int id;
    private String name;

    public Item(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
