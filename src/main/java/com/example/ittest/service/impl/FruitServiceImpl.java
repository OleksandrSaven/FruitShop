package com.example.ittest.service.impl;

import com.example.ittest.dto.CreateFruitRequestDto;
import com.example.ittest.dto.FruitDto;
import com.example.ittest.mapper.FruitMapper;
import com.example.ittest.model.Fruit;
import com.example.ittest.repository.FruitRepository;
import com.example.ittest.service.FruitService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class FruitServiceImpl implements FruitService {
    private final FruitRepository fruitRepository;
    private final FruitMapper fruitMapper;

    @Override
    public List<FruitDto> findAll(Pageable pageable) {
        return fruitRepository.findAll(pageable).stream()
                 .map(fruitMapper::toDto).toList();
    }

    @Override
    public FruitDto findById(Long id) {
        Fruit fruit = fruitRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Can't find fruit by id " + id));
        return fruitMapper.toDto(fruit);
    }

    @Override
    public FruitDto save(CreateFruitRequestDto requestDto) {
        Fruit fruit = fruitMapper.toModel(requestDto);
        return fruitMapper.toDto(fruitRepository.save(fruit));
    }

    @Override
    public FruitDto update(Long id, CreateFruitRequestDto requestDto) {
        Fruit fruit = fruitMapper.toModel(requestDto);
        fruit.setId(id);
        return fruitMapper.toDto(fruitRepository.save(fruit));
    }

    @Override
    public void deleteById(Long id) {
        fruitRepository.deleteById(id);
    }
}
