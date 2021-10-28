package repository;

import model.Customer;
import util.IdGenerator;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements GlobalRepository<Customer> {

    private static List<Customer> customers = new ArrayList<>();

    @Override
    public Customer save(Customer customer) {
        int id = IdGenerator.generateId();
        if (!customers.isEmpty()) {
            for (Customer customerFromDb : customers) {
                if (customerFromDb.getId() == id) {
                    break;
                } else {
                    customer.setId(id);
                }
            }
        } else {
            customer.setId(id);
        }
        customers.add(customer);
        return customer;
    }

    @Override
    public List<Customer> findAll() {
        return customers;
    }

    @Override
    public Customer findById(int id) {
        if (!customers.isEmpty()) {
            for (Customer customer : customers) {
                if (customer.getId() != id) {
                    return null;
                }
                return customer;
            }
        }
        return null;
    }
}
