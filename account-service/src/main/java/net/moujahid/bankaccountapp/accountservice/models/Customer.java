package net.moujahid.bankaccountapp.accountservice.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Customer {
    private String name;
    private String email;
    private String phone;
}
