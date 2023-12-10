package com.example.ittest.dto;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class CartItemDto {
    private Long id;
    private long fruitId;
    private String name;
    private int quantity;
    private BigDecimal price;
    private String image;
}
