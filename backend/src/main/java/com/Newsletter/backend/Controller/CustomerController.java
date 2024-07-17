package com.Newsletter.backend.Controller;

import com.Newsletter.backend.Entity.Customer;
import com.Newsletter.backend.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
@CrossOrigin("*")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/save")
    public Customer saveCustomer(@RequestBody Customer customer){
        return customerService.saveCurrentCustomer(customer);
    }

    @GetMapping("/getAll")
    public List<Customer> getAllCustomers(){
        return customerService.fetchAllCustomers();
    }

    @GetMapping("/get/{id}")
    public Customer fetchCustomerById(@PathVariable int id){
        return customerService.fetchById(id).get();
    }

    @PostMapping("/update/{id}")
    public Customer updateCustomerById(@PathVariable int id,@RequestBody Customer customer){
        return customerService.updateBydId(id,customer);
    }

    @DeleteMapping("/remove/{id}")
    public String deleteCustomer(@PathVariable int id){
        return customerService.deleteCustomerById(id);
    }

}
