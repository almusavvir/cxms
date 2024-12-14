package com.catalyst.customer_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers () {
        return customerRepository.findAll();
    }

    //get customers by firstname
    public List<Customer> findByFirstName(String firstName) {
        List<Customer> customerList = customerRepository.findByFirstNameIgnoreCase(firstName);
        if (CollectionUtils.isEmpty(customerList)) {
            return new ArrayList<>();
        }
        return customerList;
    }

    public Customer getCustomerById (String id) {
        return customerRepository.findById(id).orElse(null);
    }

    public Customer saveCustomer (Customer customer) {
        return customerRepository.save(customer);
    }

    public void deleteCustomer(String id) {
        customerRepository.deleteById(id);
    }
}
