package com.shopping.shopping.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String title;
    private String description;
    private float price;
    private float rating;
    private int stock;
    private String brand;
    private String category;
    private String thumbnail;
    //private List<String> images;
}
