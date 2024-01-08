package com.example.storeapi.controller;

import com.example.storeapi.modal.Orders;
import com.example.storeapi.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/orders")
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("activeOrders/{id}")
    public List<Orders> getActiveOrdersByCustomerId(@PathVariable int id){
        return orderService.getActiveOrdersByCustomer(id);
    }

}
