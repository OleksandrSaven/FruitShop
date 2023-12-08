package com.example.ittest.service;

import com.example.ittest.dto.CartItemDto;
import com.example.ittest.dto.CreateCartItemRequestDto;
import com.example.ittest.dto.ShoppingCartDto;

public interface ShoppingCartService {
    CartItemDto save(CreateCartItemRequestDto requestDto);

    ShoppingCartDto getShoppingCart(Long id);
}
