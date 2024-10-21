package net.moujahid.bankaccountapp.customerservice.clientRest;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import net.moujahid.bankaccountapp.customerservice.models.Account;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "ACCOUNT-SERVICE")
public interface AccountClientRest {
    @GetMapping("api/accounts/get-accounts-customer/{id}")
    @CircuitBreaker(name = "ACCOUNT-SERVICE-BREAKER",fallbackMethod = "getDefaultAccount")
    List<Account> findAllAccountsByIdCustomer(@PathVariable Long id);

    default List<Account> getDefaultAccount(Long id,Exception exception) {
        return null;
    }
}
