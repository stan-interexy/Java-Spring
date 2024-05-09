package com.example.springdemo.controller;

import com.example.springdemo.data.Customer;
import com.example.springdemo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SpringDemoController {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/home")
    public String sayHello(@RequestParam(value = "myName", defaultValue = "Spring Demo") String name) {
        return String.format("Hello %s!", name);
    }

    @PostMapping("/add")
    public String addCustomer(@RequestParam String first, @RequestParam String last) {
        Customer customer = new Customer();
        customer.setFirstName(first);
        customer.setLastName(last);
        customerRepository.save(customer);
        return "Added new customer to repo!";
    }

    @GetMapping("/list")
    public Iterable<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    @GetMapping("/find/{id}")
    public Customer findCustomerById(@PathVariable Integer id) {
        return customerRepository.findCustomerById(id);
    }
}
