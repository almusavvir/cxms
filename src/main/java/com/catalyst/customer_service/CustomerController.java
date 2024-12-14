package com.catalyst.customer_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/id/{id}")
    public Customer findCustomerById (@PathVariable String id) {
        return customerService.getCustomerById(id);
    }

    @GetMapping("/search/{firstName}")
    public List<Customer> findByFirstName(@PathVariable String firstName) {
        System.out.println(customerService.findByFirstName(firstName));
        return customerService.findByFirstName(firstName);
    }

    @GetMapping("/greeting")
    public String sendGreeting(@RequestParam String userName) {
        return String.format("Hello, how are you doing %s", userName);
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Customer createCustomer (@RequestBody Customer customer) {
        return customerService.saveCustomer(customer);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCustomer (@PathVariable String id) {
        customerService.deleteCustomer(id);
        return "User deleted";
        }
}
