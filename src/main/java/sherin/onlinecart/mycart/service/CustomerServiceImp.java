package sherin.onlinecart.mycart.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sherin.onlinecart.mycart.model.Customer;
import sherin.onlinecart.mycart.repository.CustomerRepository;

@Service
public class CustomerServiceImp implements CustomerService {

    @Override
    public Customer create(Customer customer) {
        customer.setPassword(passwordService.hashPassword(customer.getPassword())); // Hash password
        return repository.save(customer);
    }

    @Override
    public List<Customer> read() {
        return (List<Customer>) repository.findAll();
    }

    @Override
    public Customer read(Long id) {
        Optional<Customer> cus = repository.findById(id);
        if (cus.isEmpty()) {
            return null;
        }
        return cus.get();
    }

    @Override
    public Customer update(Long id, Customer customer) {
        Optional<Customer> cus = repository.findById(id);
        if (cus.isEmpty()) {
            return null;
        }
        return repository.save(customer);
    }

    @Override
    public Customer delete(Long id) {
        Optional<Customer> cus = repository.findById(id);
        if (cus.isEmpty()) {
            return null;
        }
        repository.deleteById(id);
        return cus.get();
    }

    @Override
    public Customer loginCheck(String userName, String password) {
        List<Customer> cus = repository.findByUserName(userName);
        System.out.println(cus);
        if (cus.isEmpty()) {
            return null;
        }
        Customer customer = cus.getFirst();
        if (passwordService.verifyPassword(password, customer.getPassword())) {
            return cus.getFirst();
        }
        return null;
    }

    @Autowired
    private CustomerRepository repository;
    @Autowired
    private PasswordService passwordService;
}
