package com.example.ittest.dto;

import java.util.List;
import lombok.Data;

@Data
public class ShoppingCartDto {
    private Long id;
    private List<CartItemDto> cartItems;
}
