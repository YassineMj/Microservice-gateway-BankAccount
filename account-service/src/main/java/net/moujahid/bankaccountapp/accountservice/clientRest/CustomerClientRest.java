package net.moujahid.bankaccountapp.accountservice.clientRest;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import net.moujahid.bankaccountapp.accountservice.models.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerClientRest {

    @GetMapping("/api/customers/{id}")
    @CircuitBreaker(name = "CUSTOMER-SERVICE-BREAKER",fallbackMethod = "getDefaultCustomer")
    Customer findCustomerById(@PathVariable Long id);

    default Customer getDefaultCustomer(Long id,Exception exception) {
        Customer defaultCustomer = new Customer();
        defaultCustomer.setEmail("Default Customer");
        defaultCustomer.setName("Default Customer");
        defaultCustomer.setPhone("Default Customer");
        return defaultCustomer;
    }
}
