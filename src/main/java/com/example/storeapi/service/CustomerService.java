package com.example.storeapi.service;

import com.example.storeapi.exception.ApiBadRequestException;
import com.example.storeapi.exception.ApiInternalServerException;
import com.example.storeapi.exception.ApiNotFoundError;
import com.example.storeapi.repositories.CustomerDAO;
import com.example.storeapi.modal.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Service;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.lang.model.util.ElementScanner14;
import java.sql.SQLSyntaxErrorException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CustomerService {

    @Autowired
    CustomerDAO customerDAO;

    public ResponseEntity<List<Customer>> getAllCustomers() {
        try {
            return new ResponseEntity<>(customerDAO.findAll(), HttpStatus.OK);
        } catch (Exception e) {
           throw new ApiInternalServerException("error with database connection");
        }
    }


    public ResponseEntity<String> addCustomer(Customer customer) {
        try {
            customerDAO.save(customer);
            return new ResponseEntity<>("customer created :successfully", HttpStatus.CREATED);
        }catch (HttpMessageNotReadableException e){
            return new ResponseEntity<>("customer created :unsuccessful", HttpStatus.BAD_REQUEST);
        }
    }


    public Customer updateCustomerById(int id, Customer productRequest) {
        try {
            Customer existingCustomer = customerDAO.findById(id).get();
            existingCustomer.setUserName(productRequest.getUserName());
            existingCustomer.setEmail(productRequest.getEmail());
            existingCustomer.setFirstName(productRequest.getFirstName());
            existingCustomer.setLastName(productRequest.getLastName());
            existingCustomer.setCreatedOn(productRequest.getCreatedOn());
            existingCustomer.setIsActive(productRequest.getIsActive());
            return customerDAO.save(existingCustomer);
        } catch (NoSuchElementException e) {
            throw new ApiInternalServerException("user id : " + id + " doesn't exist");
        }
    }

    public String deleteCustomerById(int id) {
        if (customerDAO.existsById(id)) {
            customerDAO.deleteById(id);
            return "successfully deleted customer Id: " + id;
        } else {
            throw new ApiNotFoundError("user id : " + id + " doesn't exist");
        }

    }
}




