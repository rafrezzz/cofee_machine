package org.example.cofee_machine.mapper;

import org.example.cofee_machine.dto.CoffeeDto;
import org.example.cofee_machine.dto.CoffeeCreateDto;
import org.example.cofee_machine.entity.Coffee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface CoffeeMapper
{
    CoffeeDto toDto(Coffee coffee);

    @Mapping(target = "id", ignore = true)
    Coffee toEntity(CoffeeCreateDto dto);
}
