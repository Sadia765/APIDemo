package com.example.demo.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.example.demo.domain.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long>{
    List<Customer> findByLastName(String lastName);
}