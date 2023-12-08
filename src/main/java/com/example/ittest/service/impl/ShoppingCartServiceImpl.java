package com.example.ittest.service.impl;

import com.example.ittest.dto.CartItemDto;
import com.example.ittest.dto.CreateCartItemRequestDto;
import com.example.ittest.dto.ShoppingCartDto;
import com.example.ittest.service.CartItemService;
import com.example.ittest.service.ShoppingCartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShoppingCartServiceImpl implements ShoppingCartService {
    private final CartItemService cartItemService;

    @Override
    public CartItemDto save(CreateCartItemRequestDto requestDto) {
        return cartItemService.save(requestDto);
    }

    @Override
    public ShoppingCartDto getShoppingCart(Long id) {
        ShoppingCartDto shoppingCartDto = new ShoppingCartDto();
        shoppingCartDto.setId(id);
        shoppingCartDto.setCartItems(cartItemService.findCartItemsByShoppingCarts(id));
        return shoppingCartDto;
    }
}
