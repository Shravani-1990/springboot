package com.example.demo;


import com.example.demo.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    // Custom method to print all customers
    default void printAllCustomers() {
        List<Customer> customers = findAll();
        customers.forEach(Customer::printCustomer);
    }
}

// CommandLineRunner to print customers at startup
@Repository
class CustomerRunner implements CommandLineRunner {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void run(String... args) {
        // Adding sample customers
        customerRepository.save(new Customer("John Doe"));
        customerRepository.save(new Customer("Jane Smith"));

        // Printing customers
        System.out.println("Customer List:");
        customerRepository.printAllCustomers();
    }
}
