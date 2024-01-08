package com.example.storeapi.modal;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;



@Data
@Entity
@Getter
@Setter

@NamedStoredProcedureQueries({@NamedStoredProcedureQuery(name = "firstProcedure",
        procedureName = "getActiveOrdersByCustomerId",
        parameters = {@StoredProcedureParameter(mode = ParameterMode.IN,name = "customerId",type = Integer.class)})})
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;
    private int productId;
    private int orderStatus;
    private int orderType;
    private int orderBy;
    private LocalDateTime orderedOn;
    private LocalDateTime shippedOn;
    @JsonProperty("isActive")
    private Boolean isActive;

    public Orders(int orderId, int productId, int orderStatus, int orderType, int orderedBy, LocalDateTime orderedOn, LocalDateTime shippedOn, Boolean isActive) {
        this.orderId = orderId;
        this.productId = productId;
        this.orderStatus = orderStatus;
        this.orderType = orderType;
        this.orderBy = orderedBy;
        this.orderedOn = orderedOn;
        this.shippedOn = shippedOn;
        this.isActive = isActive;
    }

    public Orders() {

    }
}
