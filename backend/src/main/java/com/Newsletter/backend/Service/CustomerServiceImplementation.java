package com.Newsletter.backend.Service;

import com.Newsletter.backend.Entity.Customer;
import com.Newsletter.backend.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CustomerServiceImplementation implements CustomerService{
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer saveCurrentCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> fetchAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> fetchById(int id) {
        return customerRepository.findById(id);
    }

    @Override
    public Customer updateBydId(int id,Customer customer) {

        Customer foundCustomer = customerRepository.findById(id).get();

        if(Objects.nonNull(customer.getCustomerName()) && !"".equalsIgnoreCase(customer.getCustomerName()))
            foundCustomer.setCustomerName(customer.getCustomerName());

        if(Objects.nonNull(customer.getCustomerAddress()) && !"".equalsIgnoreCase(customer.getCustomerAddress()))
            foundCustomer.setCustomerAddress(customer.getCustomerAddress());

        if(Objects.nonNull(customer.getCustomerEmail()) && !"".equalsIgnoreCase(customer.getCustomerEmail()))
            foundCustomer.setCustomerEmail(customer.getCustomerEmail());

        return customerRepository.save(foundCustomer);
    }

    @Override
    public String deleteCustomerById(int id) {
        customerRepository.deleteById(id);
        return "Customer Deleted Successfully!!";
    }


}
