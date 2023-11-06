package com.tekle.customer;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface CustomerDAO {
    List<Customer>selectAllCustomers();
    Optional<Customer> selectCustomerById(Integer id);
    void addCustomer(Customer customer);
    boolean emailExists(String email);
    void deleteCustomerById(Integer id);
    boolean existsPersonWithId(Integer id);
    void updateCustomer(Customer customer);
}
