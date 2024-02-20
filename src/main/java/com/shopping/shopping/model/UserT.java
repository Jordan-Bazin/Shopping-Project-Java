package com.shopping.shopping.model;

import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class UserT {
    private @Id @GeneratedValue(strategy = GenerationType.AUTO) long id;
    private String username;
    private String password;
    private String token;

    public UserT(String username, String password, String token) {
        this.username = username;
        this.password = password;
        this.token = token;
    }

    public UserT() {}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
    //private List<int> idOrders;

}
