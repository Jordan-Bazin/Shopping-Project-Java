package com.shopping.shopping.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class OrderT {
    private @Id @GeneratedValue(strategy = GenerationType.AUTO) long id;
    private long productId;
    private long userId;
    private String status;

    public OrderT(long productId, long userId, String status) {
        this.productId = productId;
        this.userId = userId;
        this.status = status;
    }

    public OrderT() {}

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
