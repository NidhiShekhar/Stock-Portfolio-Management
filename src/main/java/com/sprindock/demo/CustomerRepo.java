package com.sprindock.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo 
    extends JpaRepository<Customer, Integer>{ 
          
}
