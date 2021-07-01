package com.example.demo.controller;

import com.example.demo.domain.Customer;
import com.example.demo.repository.CustomerRepository;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {

    private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    /*
    localhost:8080/create

    {
        "firstName": "John",
        "lastName": "Doe"
    }

    {
        "firstName": "John2",
        "lastName": "Doe2"
    }
    */

    @PostMapping("/create")
    public Customer create(@RequestBody Customer customer) {
        return this.customerRepository.save(customer);
    }

    //localhost:8080/list
    @GetMapping("/list")
    public Iterable<Customer> list() {
        return this.customerRepository.findAll();
    }

    //localhost:8080/read/lastname/Doe
    @GetMapping("/read/lastname/{lastName}")
    public Iterable<Customer> read(@PathVariable String lastName) {
        return this.customerRepository.findByLastName(lastName);
    }
    /*
    localhost:8080/delete

    {
        "id": 1
    }
    */

    @DeleteMapping("delete")
    public void delete(@RequestBody Customer customer) {
        this.customerRepository.delete(customer);
    }
    /*
    //localhost:8080/update/id/1
        {
            "firstName": "John3",
            "lastName": "Doe3"
        }
    */
    @PatchMapping("/update/id/{id}")
    public void patchUpdate(@RequestBody Customer customerInput,@PathVariable Long id) {
        Customer customer = this.customerRepository.findById(id).get();
        customer.setFirstName(customerInput.getFirstName());
        customer.setLastName(customerInput.getLastName());
        this.customerRepository.save(customer);
    }

    /*
    //localhost:8080/update/id/1
        {
            "firstName": "John4",
            "lastName": "Doe4"
        }
    */
    @PutMapping("/update/id/{id}")
    public void putUpdate(@RequestBody Customer customerInput,@PathVariable Long id) {
        Customer customer = this.customerRepository.findById(id).get();
        customer.setFirstName(customerInput.getFirstName());
        customer.setLastName(customerInput.getLastName());
        this.customerRepository.save(customer);
    }



}
