package com.example.ittest.service.impl;

import com.example.ittest.dto.CartItemDto;
import com.example.ittest.dto.CreateCartItemRequestDto;
import com.example.ittest.dto.UpdateCartItemDto;
import com.example.ittest.mapper.CartItemMapper;
import com.example.ittest.model.CartItem;
import com.example.ittest.repository.CartItemRepository;
import com.example.ittest.repository.FruitRepository;
import com.example.ittest.repository.ShoppingCartRepository;
import com.example.ittest.service.CartItemService;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartItemServiceImpl implements CartItemService {
    private final FruitRepository fruitRepository;
    private final ShoppingCartRepository shoppingCartRepository;
    private final CartItemRepository cartItemRepository;
    private final CartItemMapper cartItemMapper;

    @Override
    public CartItemDto save(CreateCartItemRequestDto requestDto) {
        if (cartItemRepository.findByFruit_Id(requestDto.getFruitId()).isEmpty()) {
            CartItem cartItem = new CartItem();
            cartItem.setFruit(fruitRepository.findById(requestDto.getFruitId()).get());
            cartItem.setQuantity(requestDto.getQuantity());
            cartItem.setShoppingCart(shoppingCartRepository
                    .getReferenceById(requestDto.getShoppingCartId()));
            return cartItemMapper.toDto(cartItemRepository.save(cartItem));
        }
        return null;
    }

    public List<CartItemDto> findCartItemsByShoppingCarts(Long id) {
        return cartItemRepository.findCartItemsByShoppingCartId(id).stream()
                .map(cartItemMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public CartItemDto update(Long id, UpdateCartItemDto updateCartItemDto) {
        CartItem cartItem = cartItemRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Can't find item by id " + id));
        cartItem.setQuantity(updateCartItemDto.getQuantity());
        return cartItemMapper.toDto(cartItemRepository.save(cartItem));
    }

    @Override
    public void delete(Long id) {
        cartItemRepository.deleteById(id);
    }
}
