package ru.kazakovushka.edu.bankomat;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Data
public class Card {
    @Id
    UUID id;
    String number;
    boolean active;
    String pin;
    BigDecimal balance;
}
