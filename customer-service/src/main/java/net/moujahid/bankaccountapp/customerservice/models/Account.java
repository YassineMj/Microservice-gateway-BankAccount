package net.moujahid.bankaccountapp.customerservice.models;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
public class Account {
    private Double balance;
    private LocalDate createAt;
    private String type;
}
