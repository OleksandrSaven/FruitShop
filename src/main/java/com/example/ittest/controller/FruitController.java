package com.example.ittest.controller;

import com.example.ittest.dto.CreateFruitRequestDto;
import com.example.ittest.dto.FruitDto;
import com.example.ittest.service.FruitService;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/fruits")
public class FruitController {

    private final FruitService fruitService;

    @GetMapping
    public List<FruitDto> findAll(Pageable pageable) {
        return fruitService.findAll(pageable);
    }

    @GetMapping("/{id}")
    public FruitDto getFruitById(@PathVariable Long id) {
        return fruitService.findById(id);
    }

    @PutMapping("/{id}")
    public FruitDto update(@PathVariable Long id,
                           @Valid @RequestBody CreateFruitRequestDto fruitRequestDto) {
        return fruitService.update(id, fruitRequestDto);
    }

    @PostMapping
    public FruitDto createFruit(@RequestBody @Valid CreateFruitRequestDto fruitDto) {
        return fruitService.save(fruitDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        fruitService.deleteById(id);
    }
}
