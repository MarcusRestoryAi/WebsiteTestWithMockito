package org.example;

public class Website {

    public Database userDatabase = new Database();
    public User currentUser;

    public boolean logIn(String username, String password) {
        User user = userDatabase.GetUserByUsername(username);
        if (user.getPassword().equals(password)) {
            currentUser = user;
            System.out.println("Login Successful!");
            return true;
        }
        return false;
    }

    public boolean changeName(String newName) {
        if (currentUser != null) {
            userDatabase.SaveNewUsername(currentUser.getUsername(), newName);
            currentUser.setUsername(newName);
            System.out.println("Change name Successful!");
            return true;
        }
        return false;
    }
}
