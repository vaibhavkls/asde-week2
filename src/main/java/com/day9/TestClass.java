package com.day9;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

public class TestClass {
    public static void main(String args[]) {
        System.out.println("Hello World!");

        //System.err.println("An error occured");

        Properties properties = System.getProperties();
        //System.out.println(properties);

        GetProps props = new GetProps();
        props.loadProperties();
        props.readFromFile();

        InputStream inputStream = TestClass.class.getClassLoader().getResourceAsStream("app.properties");

    }
    
}
