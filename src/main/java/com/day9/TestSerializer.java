package com.day9;

import java.io.*;

public class TestSerializer implements Serializable {

    public static void main(String[] args) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream("C:/Users/Vaibhav/user.ser");
            oos = new ObjectOutputStream(fos);
            // User object initialize
            TestSerializer test = new TestSerializer();
            TestSerializer.User user = test.new User();
            user.name = "Vaibhav";
            user.id = 1;

            // Serialize
            oos.writeObject(user);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                fos.close();
                oos.close();

            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        readRandomObject();

    }

    public static void readRandomObject() {
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            fis = new FileInputStream("C:/Users/Vaibhav/user.ser");
            ois = new ObjectInputStream(fis);
            System.out.println(((User) ois.readObject()).name);
        } catch (IOException | ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public class User implements Serializable {
        public String name;
        public int id;
    }

    
    
}
