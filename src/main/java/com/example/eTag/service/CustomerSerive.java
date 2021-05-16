package com.example.eTag.service;

import com.example.eTag.domain.Customer;
import com.example.eTag.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Khairul Islam Azam
 * @since 1.0
 */
@Service
public class CustomerSerive {

    private final CustomerRepository customerRepository;

    public CustomerSerive(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> findAllUser() {
        return customerRepository.findAll();
    }

    public String saveCustomer(Customer customer) {
        String message;
        Customer tempCustomer = customerRepository.findByEmail(customer.getEmail());
        if (!tempCustomer.getEmail().equalsIgnoreCase(customer.getEmail())) {
            message = "save";
            customerRepository.save(customer);
        } else {

            message = "notSave";
        }
        return message;
    }

    public List<Customer> customerList() {
        return customerRepository.findAll();
    }

}
