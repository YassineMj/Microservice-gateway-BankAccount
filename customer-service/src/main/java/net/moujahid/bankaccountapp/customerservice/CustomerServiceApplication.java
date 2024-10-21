package net.moujahid.bankaccountapp.customerservice;

import net.moujahid.bankaccountapp.customerservice.entities.Customer;
import net.moujahid.bankaccountapp.customerservice.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner initDatabase(CustomerRepository customerRepository) {
        return args -> {

            Customer customer1 = new Customer(null,"John Doe", "johndoe@example.com", "1234567890",null);
            Customer customer2 = new Customer(null,"Jane Smith", "janesmith@example.com", "0987654321",null);
            Customer customer3 = new Customer(null,"Alice Brown", "alicebrown@example.com", "5555555555",null);

            customerRepository.save(customer1);
            customerRepository.save(customer2);
            customerRepository.save(customer3);

            System.out.println("Sample customers added to the database.");
        };
    }

}
