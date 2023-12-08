package com.example.ittest.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateCartItemRequestDto {
    @NotNull
    private Long fruitId;
    @NotNull
    @Min(1)
    private int quantity;
    @NotNull
    private Long shoppingCartId;
}
