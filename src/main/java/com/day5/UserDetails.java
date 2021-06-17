package com.day5;

public class UserDetails {

    String username;
    static int i;

    static {
        i=10;
        System.out.println("Inside the static block");
    }

    UserDetails() {
        System.out.println("Inside constructor");
    }

    public static void printName(String name) {
        System.out.println("Inside static method : " + name);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "UserDetails [username=" + username + "]";
    }
    
    
}
