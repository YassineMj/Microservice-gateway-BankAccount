package net.moujahid.bankaccountapp.accountservice;

import net.moujahid.bankaccountapp.accountservice.entities.Account;
import net.moujahid.bankaccountapp.accountservice.enums.AccountType;
import net.moujahid.bankaccountapp.accountservice.repositories.AccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class AccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner initDatabase(AccountRepository accountRepository) {
        return args -> {

            Account account1= new Account(UUID.randomUUID().toString(),Double.valueOf(10000), LocalDate.now(), AccountType.CHECKING,Long.valueOf(1));
            Account account2= new Account(UUID.randomUUID().toString(),Double.valueOf(20000), LocalDate.now(), AccountType.SAVINGS,Long.valueOf(2));
            Account account3= new Account(UUID.randomUUID().toString(),Double.valueOf(30000), LocalDate.now(), AccountType.CHECKING,Long.valueOf(3));
            Account account4= new Account(UUID.randomUUID().toString(),Double.valueOf(1310000), LocalDate.now(), AccountType.CHECKING,Long.valueOf(1));

            accountRepository.save(account1);
            accountRepository.save(account2);
            accountRepository.save(account3);
            accountRepository.save(account4);

            System.out.println("Sample Account added to the database.");
        };
    }

}
