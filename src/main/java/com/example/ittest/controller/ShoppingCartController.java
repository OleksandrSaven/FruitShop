package com.example.ittest.controller;

import com.example.ittest.dto.CartItemDto;
import com.example.ittest.dto.CreateCartItemRequestDto;
import com.example.ittest.dto.ShoppingCartDto;
import com.example.ittest.dto.UpdateCartItemDto;
import com.example.ittest.service.CartItemService;
import com.example.ittest.service.ShoppingCartService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/cart")
@CrossOrigin
public class ShoppingCartController {
    private final ShoppingCartService shoppingCartService;
    private final CartItemService cartItemService;

    @PostMapping
    public CartItemDto createShoppingCart(@RequestBody
                                       @Valid CreateCartItemRequestDto requestDto) {
        return shoppingCartService.save(requestDto);
    }

    @GetMapping("/{id}")
    public ShoppingCartDto getShoppingCart(@PathVariable Long id) {
        return shoppingCartService.getShoppingCart(id);
    }

    @PutMapping("/{id}")
    public CartItemDto update(@PathVariable Long id,
                              @Valid @RequestBody UpdateCartItemDto updateCartItemDto) {
        return cartItemService.update(id, updateCartItemDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        cartItemService.delete(id);
    }
}
