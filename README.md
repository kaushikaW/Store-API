# Documentation
# Store API

## Get all customer details:
### GET
http://localhost:8080/api/v1/customers

## Create a customer
### POST
http://localhost:8080/api/v1/customers

```json
{
    "userName": "kaishika",
    "email": "user1@example.com",
    "firstName": "John",
    "lastName": "Doe",
    "createdOn": "2023-01-01 12:00:00",
    "isActive": true
}
````
Succsess message: ```customer created :successfully```

## get all active orders by customer ID
### GET
http://localhost:8080/api/v1/orders/activeOrders/userId

Eg: http://localhost:8080/api/v1/orders/activeOrders/2
output:
```﻿[
    [
        2,
        2,
        "Product 2",
        2,
        "Supplier B",
        40,
        1,
        2,
        2,
        "2023-02-25T05:30:00.000+00:00",
        "2023-02-28T10:00:00.000+00:00",
        true
    ],
    [
        3,
        3,
        "Product 3",
        3,
        "Supplier C",
        16,
        0,
        1,
        2,
        "2023-03-30T08:15:00.000+00:00",
        "2023-04-02T10:30:00.000+00:00",
        true
    ]
]
````
## update customer by id
### PUT
http://localhost:8080/api/v1/customers/userId

eg: http://localhost:8080/api/v1/customers/2

jason object
```json
{
    "userName": "name Updated",
    "email": "user1@example.com",
    "firstName": "John",
    "lastName": "Doe",
    "createdOn": "2023-01-01 12:00:00",
    "isActive": true
}
````
respone:
```json
{
    "userId": 3,
    "userName": "name Updated",
    "email": "user1@example.com",
    "firstName": "John",
    "lastName": "Doe",
    "createdOn": "2023-01-01 12:00:00",
    "isActive": true
}
````
## delete customer by id
### DELETE
http://localhost:8080/api/v1/customers/customerId

eg: http://localhost:8080/api/v1/customers/4

responce ```successfully deleted customer Id: 4```






