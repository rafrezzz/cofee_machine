package org.example.cofee_machine.controller;

import lombok.RequiredArgsConstructor;
import org.example.cofee_machine.dto.CoffeeCreateDto;
import org.example.cofee_machine.dto.CoffeeDto;
import org.example.cofee_machine.service.CoffeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("coffees")
@RequiredArgsConstructor
public class CoffeeController
{
    private final CoffeeService coffeeService;

    @PostMapping 
    CoffeeDto create(@RequestBody CoffeeCreateDto dto)
    {
        return coffeeService.create(dto);
    }

    
    @GetMapping
    List<CoffeeDto> coffees()
    {
        return coffeeService.allCoffees();
    }

    @GetMapping("{id}")
    ResponseEntity<CoffeeDto> coffee(@PathVariable Long id)
    {
        return coffeeService.oneCoffee(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
