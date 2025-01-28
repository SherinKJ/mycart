package sherin.onlinecart.mycart.service;

import java.util.List;

import sherin.onlinecart.mycart.model.Customer;

public interface CustomerService {
    Customer create(Customer customer);

    List<Customer> read();

    Customer read(Long id);

    Customer update(Long id, Customer customer);

    Customer delete(Long id);

    Customer loginCheck(String userName, String password);
}
