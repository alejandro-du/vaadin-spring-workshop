package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    @Autowired
    private CustomerRepository customerRepository;

    public String greet(String name) {

        Customer existingCustomer = customerRepository.getByName(name);

        if (existingCustomer != null) {
            return "Hi " + name + ", welcome back!";

        } else {
            Customer newCustomer = new Customer();
            newCustomer.setName(name);

            customerRepository.save(newCustomer);

            return "Hi " + name;
        }

    }

}
