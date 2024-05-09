package com.example.springdemo.repository;

import com.example.springdemo.data.Customer;
import org.springframework.data.repository.CrudRepository;
public interface CustomerRepository extends CrudRepository<Customer, Integer> {

    Customer findCustomerById(Integer id);
}
