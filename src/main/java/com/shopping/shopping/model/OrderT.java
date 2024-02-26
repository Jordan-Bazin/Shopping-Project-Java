package com.shopping.shopping.model;

import jakarta.persistence.*;

import java.util.ArrayList;

@Entity
public class OrderT {
    private @Id @GeneratedValue(strategy = GenerationType.AUTO) long id;
    @ElementCollection
    private ArrayList<Integer> productId;
    private int userId;
    private String status;

    public OrderT(ArrayList<Integer> productId, int userId, String status) {
        this.productId = productId;
        this.userId = userId;
        this.status = status;
    }

    public OrderT() {}

    public ArrayList<Integer> getProductId() {
        return productId;
    }

    public void setProductId(ArrayList<Integer> productId) {
        this.productId = productId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
