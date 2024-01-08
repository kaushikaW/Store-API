package com.example.storeapi.repositories;

import com.example.storeapi.modal.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDAO extends JpaRepository<Orders, Integer> {


    @Procedure(value = "getActiveOrdersCount")
    public Integer getActiveOrdersCount();


}
