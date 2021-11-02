package service.impl;

import model.Customer;
import repository.CustomerRepository;
import service.CustomerService;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {

    private static CustomerRepository customerRepository = new CustomerRepository();

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }
}