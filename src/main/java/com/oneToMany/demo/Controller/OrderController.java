package com.oneToMany.demo.Controller;

import com.oneToMany.demo.DTO.InputRequest;
import com.oneToMany.demo.DTO.OrderResponse;
import com.oneToMany.demo.Entity.Customer;
import com.oneToMany.demo.Repository.CustomerRepository;
import com.oneToMany.demo.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class OrderController {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ProductRepository productRepository;


    @PostMapping("/placeOrder")
    public Customer placeOrder(@RequestBody InputRequest request){
        return customerRepository.save(request.getCustomer());
    }

    @GetMapping("/findAllOrders")
    public List<Customer> findAllOrders(){
        return customerRepository.findAll();
    }

    @GetMapping("/getInfo")
    public List<OrderResponse> getInfo(){
        return customerRepository.getJoinInformation();
    }

    @DeleteMapping("/deleteCustomer/{id}")
    public Customer deleteCustomer(@PathVariable int id){
        Optional<Customer> customer = customerRepository.findById(id);
        Customer customer1;
        if (customer.isPresent()){
             customer1 = customer.get();
            customerRepository.delete(customer1);
        }else{
            throw new RuntimeException("Customer not found!");
        }
        return customer1;
    }
}
