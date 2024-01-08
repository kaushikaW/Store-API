package com.example.storeapi.service;

import com.example.storeapi.exception.ApiInternalServerException;
import com.example.storeapi.repositories.OrderDAO;
import com.example.storeapi.modal.Orders;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderDAO orderDAO;

    @Autowired
    private EntityManager em;



    @SuppressWarnings("unchecked")
    public List<Orders> getActiveOrdersByCustomer(int customerId) {
       try {
           return em.createNamedStoredProcedureQuery("firstProcedure").setParameter("customerId", customerId).getResultList();
       }catch (Exception e){
           throw new ApiInternalServerException("error with database connection");
       }
    }


}
