package com.tekle.customer;

import com.tekle.exception.ResourceNotFound;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerDAO customerDAO;

    public CustomerService(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    public List<Customer> getAllCustomers(){
        return customerDAO.selectAllCustomers();
    }
    public Customer getCustomer(Integer id){
        return customerDAO.selectCustomerById(id).orElseThrow(()->new ResourceNotFound("customer with id:[%s] is not found".formatted(id)));
    }
}
