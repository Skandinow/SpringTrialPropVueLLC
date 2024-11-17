package com.example.springtrial.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@Table(name="products")
@AllArgsConstructor
public class Product {
    public Product() {}

    @Id
    @GeneratedValue
    private long id;

    private String productId;

    @Enumerated(EnumType.STRING)
    private Status status;

    private String fulfillmentCenter;

    private int quantity;

    private int value;
}
