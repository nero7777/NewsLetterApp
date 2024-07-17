package com.Newsletter.backend.Service;

import com.Newsletter.backend.Entity.Customer;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;


public interface CustomerService {
    Customer saveCurrentCustomer(Customer customer);

    List<Customer> fetchAllCustomers();

    Optional<Customer> fetchById(int id);

   String deleteCustomerById(int id);

    Customer updateBydId(int id,Customer customer);
}
