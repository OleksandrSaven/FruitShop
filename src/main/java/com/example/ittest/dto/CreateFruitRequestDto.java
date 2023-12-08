package com.example.ittest.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import lombok.Data;

@Data
public class CreateFruitRequestDto {
    @NotBlank
    private String name;
    @NotNull
    @Min(0)
    private BigDecimal price;
    private String description;
}
