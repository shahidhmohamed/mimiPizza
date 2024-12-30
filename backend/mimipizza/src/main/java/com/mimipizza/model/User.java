package com.mimipizza.model;

public class User {
    
    private String email;
    private int userID;
    private String username;
    private String login;
    private String number;
    private String password;
    private String favorites;
    
    public void setUserID(int userID) {
        this.userID = userID;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setFavorites(String favorites) {
        this.favorites = favorites;
    }
    public int getUserID() {
        return userID;
    }
    public String getUsername() {
        return username;
    }
    public String getLogin() {
        return login;
    }
    public String getPassword() {
        return password;
    }
    public String getFavorites() {
        return favorites;
    }
    public String getEmail() {
        return email;
    }
    public String getNumber() {
        return number;
    }   
}
