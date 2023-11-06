package com.tekle.customer;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository("list")
public class CustomerListDataAccessService implements CustomerDAO{
    static List<Customer>customers;
    static {
        customers=new ArrayList<>();
        Customer alex = new Customer(1, "alex", "alex@gmail.com", 23);
        customers.add(alex);
        Customer tekle = new Customer(2, "tekle", "tekle@gmail.com", 24);
        customers.add(tekle);
    }
    @Override
    public List<Customer> selectAllCustomers() {
        return customers;
    }

    @Override
    public Optional<Customer> selectCustomerById(Integer customerId) {
        return customers.stream()
                .filter(c -> c.getId().equals(customerId))
                .findFirst();
    }

    @Override
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    @Override
    public boolean emailExists(String email) {
        for(Customer customer:customers){
            if(customer.getEmail().equals(email)){
                return true;
            }
        }
        return false;
//        return customers.
//                stream().
//                anyMatch(c->c.getEmail().equals(email));
    }

    @Override
    public void deleteCustomerById(Integer id) {
        for(Customer customer:customers){
            if(customer.getId().equals(id)){
                customers.remove(customer);
                break;
            }
        }
    }

    @Override
    public boolean existsPersonWithId(Integer id) {
        for(Customer customer:customers){
            if(customer.getId().equals(id)){
                return true;
            }
        }
        return false;
    }

    @Override
    public void updateCustomer(Customer customer) {
        customers.add(customer);
    }


}
