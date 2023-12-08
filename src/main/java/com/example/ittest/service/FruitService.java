package com.example.ittest.service;

import com.example.ittest.dto.CreateFruitRequestDto;
import com.example.ittest.dto.FruitDto;
import java.util.List;
import org.springframework.data.domain.Pageable;

public interface FruitService {
    List<FruitDto> findAll(Pageable pageable);

    FruitDto findById(Long id);

    FruitDto save(CreateFruitRequestDto fruit);

    FruitDto update(Long id, CreateFruitRequestDto fruit);

    void deleteById(Long id);
}
