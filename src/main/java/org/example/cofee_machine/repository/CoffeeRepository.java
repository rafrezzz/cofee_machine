package org.example.cofee_machine.repository;

import org.example.cofee_machine.entity.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoffeeRepository extends JpaRepository<Coffee, Long>
{
    
}
