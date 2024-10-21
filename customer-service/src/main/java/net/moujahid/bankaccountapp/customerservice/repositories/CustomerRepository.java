package net.moujahid.bankaccountapp.customerservice.repositories;

import net.moujahid.bankaccountapp.customerservice.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
