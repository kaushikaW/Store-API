package com.example.storeapi.controller;
import com.example.storeapi.modal.Customer;
import com.example.storeapi.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping()
    public ResponseEntity<List<Customer>> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @PostMapping()
    public ResponseEntity<String> addCustomer(@RequestBody Customer customer){
        return customerService.addCustomer(customer);
    }

    @PutMapping("{id}")
    public Customer updateCustomerById(@PathVariable int id,@RequestBody Customer customerRequest){
        return customerService.updateCustomerById(id,customerRequest);
    }

    @DeleteMapping("{id}")
    public String deleteCustomerByTd(@PathVariable int id){
         return customerService.deleteCustomerById(id);
    }






}
