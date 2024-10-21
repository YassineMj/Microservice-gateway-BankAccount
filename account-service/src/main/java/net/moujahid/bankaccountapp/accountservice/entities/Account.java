package net.moujahid.bankaccountapp.accountservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.moujahid.bankaccountapp.accountservice.enums.AccountType;
import net.moujahid.bankaccountapp.accountservice.models.Customer;

import java.time.LocalDate;

@Entity
@Table(name = "accounts")
@Setter @Getter @AllArgsConstructor @NoArgsConstructor

public class Account {
    @Id
    private String accountId;
    @Transient
    private Customer customer;
    private Double balance;
    private LocalDate createAt;

    @Enumerated(EnumType.STRING)
    private AccountType type;

    private Long customerId;

    public Account(String accountId, Double balance, LocalDate createAt, AccountType type, Long customerId) {
        this.accountId = accountId;
        this.balance = balance;
        this.createAt = createAt;
        this.type = type;
        this.customerId = customerId;
    }
}
