package com.example.shop_ban_hang.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class Product {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private double price;
    private int quantity;
    private String description;
    private String image;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;


}
