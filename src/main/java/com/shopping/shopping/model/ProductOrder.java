package com.shopping.shopping.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ProductOrder {
    private @Id @GeneratedValue(strategy = GenerationType.AUTO) long id;
    private long idProduct;
    private long idOrder;
    private int quantity;

    public ProductOrder(long idProduct, long idOrder, int quantity) {
        this.idProduct = idProduct;
        this.idOrder = idOrder;
        this.quantity = quantity;
    }

    public ProductOrder() {}

    public long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(long idProduct) {
        this.idProduct = idProduct;
    }

    public long getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(long idOrder) {
        this.idOrder = idOrder;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
