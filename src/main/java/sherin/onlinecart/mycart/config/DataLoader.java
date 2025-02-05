package sherin.onlinecart.mycart.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import sherin.onlinecart.mycart.model.Customer;
import sherin.onlinecart.mycart.repository.CustomerRepository;
import sherin.onlinecart.mycart.service.PasswordService;

@Component
public class DataLoader implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        if (!repository.existsByUserName("admin@mail.com")) {
            String hashedPassword = passwordService.hashPassword("123456");
            repository.save(new Customer(null, "Administrator", "admin@mail.com", hashedPassword, "admin"));
        }
    }

    @Autowired
    private CustomerRepository repository;
    @Autowired
    private PasswordService passwordService;
}
