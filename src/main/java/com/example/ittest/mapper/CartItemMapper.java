package com.example.ittest.mapper;

import com.example.ittest.config.MapperConfig;
import com.example.ittest.dto.CartItemDto;
import com.example.ittest.model.CartItem;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(config = MapperConfig.class)
public interface CartItemMapper {
    CartItemDto toDto(CartItem cartItem);

    @AfterMapping
    default void setFruitId(@MappingTarget CartItemDto cartItemDto, CartItem cartItem) {
        cartItemDto.setFruitId(cartItem.getFruit().getId());
    }

    @AfterMapping
    default void setFruitTitle(@MappingTarget CartItemDto cartItemDto, CartItem cartItem) {
        cartItemDto.setName(cartItem.getFruit().getName());
    }

    @AfterMapping
    default void setFruitPrice(@MappingTarget CartItemDto cartItemDto, CartItem cartItem) {
        cartItemDto.setPrice(cartItem.getFruit().getPrice());
    }
}
