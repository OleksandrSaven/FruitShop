package com.example.ittest.dto;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class FruitDto {
    private Long id;
    private String name;
    private BigDecimal price;
    private String description;
    private String image;
}
