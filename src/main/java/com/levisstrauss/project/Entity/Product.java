package com.levisstrauss.project.Entity;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

@Entity
public class Product {
    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String item_id;
    private String name;
    private Double price;
    private String description;
    private String status;
    private String image;

    public Product(Long id, String item_id, String name, Double price, String description, String status, String image) {
        this.id = id;
        this.item_id = item_id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.status = status;
        this.image = image;
    }

    public Product() {
    }

    // Getters, setters, constructors, etc.
    public String getItem_id() {
        return item_id;
    }

    public void setItem_id(String item_Id) {
        this.item_id = item_Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image= image;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
