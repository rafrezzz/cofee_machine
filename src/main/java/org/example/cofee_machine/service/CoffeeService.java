package org.example.cofee_machine.service;

import org.example.cofee_machine.dto.CoffeeDto;
import org.example.cofee_machine.dto.CoffeeCreateDto;

import java.util.List;
import java.util.Optional;

public interface CoffeeService
{
    public List<CoffeeDto> allCoffees();
    Optional<CoffeeDto> oneCoffee(Long id);
    CoffeeDto create(CoffeeCreateDto coffeeCreateDto);
    /// update


}
