package com.desafio.chavepix.repositories;

import com.desafio.chavepix.domains.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {


}
