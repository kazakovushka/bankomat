package ru.kazakovushka.edu.bankomat;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CardRepository extends CrudRepository<Card, UUID> {
    Card findByNumber(String number);
}
