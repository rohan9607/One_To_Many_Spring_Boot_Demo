package com.oneToMany.demo.Repository;

import com.oneToMany.demo.DTO.OrderResponse;
import com.oneToMany.demo.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Query("SELECT new com.oneToMany.demo.DTO.OrderResponse(c.name, p.name) FROM Customer c JOIN c.products p")
    public List<OrderResponse> getJoinInformation();
}
