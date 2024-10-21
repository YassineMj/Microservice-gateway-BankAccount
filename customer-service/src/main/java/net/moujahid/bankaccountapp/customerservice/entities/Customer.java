package net.moujahid.bankaccountapp.customerservice.entities;

import jakarta.persistence.*;
import lombok.*;
import net.moujahid.bankaccountapp.customerservice.models.Account;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customers")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String phone;

    @Transient
    private List<Account> accounts;

}