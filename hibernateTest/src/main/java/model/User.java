/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Laura
 */
public class User {

    private int idUser;
    private String username;
    private String pass;
    private int type;       // 1= Admin, 2= Customer

    public User() {
    }
    
    public User(String username, String pass, int type) {
        this.username = username;
        this.pass = pass;
        this.type = type;
    }

    public User(int idUser, String username, String pass, int type) {
        this.idUser = idUser;
        this.username = username;
        this.pass = pass;
        this.type = type;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

}
