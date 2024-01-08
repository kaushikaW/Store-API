package com.example.storeapi.modal;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int userId;

    private String userName;

    private String email;

    private String firstName;

    private String lastName;

    private String createdOn;

    private Boolean isActive;

    public Customer() {

    }

    public Customer(String userName, String email, String firstName, String lastName, String createdOn, Boolean isActive) {
        this.userName = userName;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.createdOn = createdOn;
        this.isActive = isActive;
    }


}


