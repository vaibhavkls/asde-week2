package com.day9;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GetProps {

    public void loadProperties() {

        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("app.properties");
        Properties properties = new Properties();
        try {
            properties.load(inputStream);
            System.out.println(properties);
        } catch (IOException e) {
            System.err.println("Properties were not loaded");
        }

    }

    public void readFromFile() {
        InputStream inputStream = null;
        BufferedReader reader = null;
        try {
            inputStream = new FileInputStream(
                    "C:/Learning/Sapient/Repositories/asde/day5-oop/src/main/java/com/day9/testfile.txt");
            
            reader = new BufferedReader(new java.io.InputStreamReader(inputStream));
            try {
                System.out.println(reader.readLine());
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
