package net.moujahid.bankaccountapp.accountservice.repositories;

import net.moujahid.bankaccountapp.accountservice.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {
    List<Account> findByCustomerId(Long customerId);
}
