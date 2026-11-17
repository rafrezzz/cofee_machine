package org.example.cofee_machine.service;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.example.cofee_machine.dto.CoffeeCreateDto;
import org.example.cofee_machine.dto.CoffeeDto;
import org.example.cofee_machine.entity.Coffee;
import org.example.cofee_machine.mapper.CoffeeMapper;
import org.example.cofee_machine.repository.CoffeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CoffeeServiceImpl implements CoffeeService {

    private final CoffeeRepository coffeeRepository;
    private final CoffeeMapper mapper;


    @PostConstruct
    void initDB()
    {
        coffeeRepository.saveAll(List.of(
                        new Coffee("Espresso", 200),
                        new Coffee("Ristretto", 100)
                )
        );
    }

    @Override
    public List<CoffeeDto> allCoffees()
    {
        return coffeeRepository.findAll().stream().map(mapper::toDto).toList();
    }

    @Override
    public CoffeeDto create(CoffeeCreateDto dto)
    {
        Coffee entity = mapper.toEntity(dto);
        Coffee saved = coffeeRepository.save(entity);
        return mapper.toDto(saved);
    }

    @Override
    public Optional<CoffeeDto> oneCoffee(Long id)
    {
        return coffeeRepository.findById(id).map(mapper::toDto);
    }
}
