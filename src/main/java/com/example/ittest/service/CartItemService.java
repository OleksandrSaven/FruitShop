package com.example.ittest.service;

import com.example.ittest.dto.CartItemDto;
import com.example.ittest.dto.CreateCartItemRequestDto;
import com.example.ittest.dto.UpdateCartItemDto;
import java.util.List;

public interface CartItemService {
    CartItemDto save(CreateCartItemRequestDto requestDto);

    List<CartItemDto> findCartItemsByShoppingCarts(Long id);

    CartItemDto update(Long id, UpdateCartItemDto updateCartItemDto);

    void delete(Long id);
}
