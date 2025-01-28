package sherin.onlinecart.mycart.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import sherin.onlinecart.mycart.model.Customer;
import sherin.onlinecart.mycart.repository.CustomerRepository;

@Component
public class DataLoader implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        if (!repository.existsByUserName("admin@mail.com")) {
            repository.save(new Customer(null, "Administrator", "admin@mail.com", "123456", "admin"));
        }
    }

    @Autowired
    private CustomerRepository repository;
}
