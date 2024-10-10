package com.aditya.ecom_project1.Models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId; // Primary key, auto-generated

    private String productName; // Name of the product
    private String description; // Description of the product
    private String brand; // Brand of the product
    private String category; // Category of the product
    private BigDecimal price; // Price of the product
    //    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date releaseDate; // Release date of the product
    private Boolean available ; // Availability status of the product
    private int quantity; // Quantity in stock
}
