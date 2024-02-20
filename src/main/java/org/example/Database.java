package org.example;

public class Database {

    public User GetUserByUsername(String name) {
        // This function is actually a database call
        // that we don't want to do for a unit test
        return null;
    }

    public boolean SaveNewUsername(String previousName, String newName) {
        // Function for changing database name
        return false;
    }
}
