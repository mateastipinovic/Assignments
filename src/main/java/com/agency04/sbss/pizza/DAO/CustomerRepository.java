package com.agency04.sbss.pizza.DAO;

import com.agency04.sbss.pizza.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Customer findByUsername(String name);

    void deleteByUsername(String username);
}
