package com.youssef.costumer.repository;

import com.youssef.costumer.module.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer,Integer> {

}
