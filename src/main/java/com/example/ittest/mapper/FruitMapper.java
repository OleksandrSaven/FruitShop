package com.example.ittest.mapper;

import com.example.ittest.config.MapperConfig;
import com.example.ittest.dto.CreateFruitRequestDto;
import com.example.ittest.dto.FruitDto;
import com.example.ittest.model.Fruit;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface FruitMapper {
    FruitDto toDto(Fruit fruit);

    Fruit toModel(CreateFruitRequestDto requestDto);
}
