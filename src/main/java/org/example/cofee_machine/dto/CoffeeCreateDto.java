package org.example.cofee_machine.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record CoffeeCreateDto(
    @NotBlank(message = "Coffee name must not be null") 
    String name, 
    @Positive(message = "Price must be positive") 
    int price) {
}
