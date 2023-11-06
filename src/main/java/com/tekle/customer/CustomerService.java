package com.tekle.customer;

import com.tekle.exception.DuplicateResourceException;
import com.tekle.exception.RequestValidationException;
import com.tekle.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerDAO customerDAO;

    public CustomerService(@Qualifier("jpa") CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    public List<Customer> getAllCustomers(){
        return customerDAO.selectAllCustomers();
    }
    public Customer getCustomer(Integer id){
        return customerDAO.selectCustomerById(id).orElseThrow(()->new ResourceNotFoundException("customer with id:[%s] is not found".formatted(id)));
    }
    public void addCustomer(RegistrationRequest registrationRequest){
        String email = registrationRequest.email();
        if(customerDAO.emailExists(email)){
            throw new DuplicateResourceException("Customer with email [%s] already exists.".formatted(email));
        }
        Customer customer = new Customer(
                registrationRequest.name(),
                registrationRequest.email(),
                registrationRequest.age()
        );
        customerDAO.addCustomer(customer);
    }
    public void deleteCustomerById(Integer id){

        if(!customerDAO.existsPersonWithId(id)){
            throw new ResourceNotFoundException("customer with id:[%s] is not found".formatted(id));
        }
        customerDAO.deleteCustomerById(id);
    }
    public void updateCustomer(Integer id,RegistrationRequest request){
        if(!customerDAO.existsPersonWithId(id)){
            throw new ResourceNotFoundException("customer with id:[%s] is not found".formatted(id));
        }
        Customer customer = getCustomer(id);
        boolean changes=false;
        if(request.name()!=null && !request.name().equals(customer.getName())){
            customer.setName(request.name());
            changes=true;
        }
        if(request.age()!=null && !request.age().equals(customer.getAge())){
            customer.setAge(request.age());
            changes=true;
        }
        if(request.email()!=null && !request.email().equals(customer.getEmail())){
            if(customerDAO.emailExists(request.email())){
                throw new DuplicateResourceException("Customer with email [%s] already exists.".formatted(request.email()));
            }
            customer.setEmail(request.email());
            changes=true;
        }
        if(!changes){
            throw new RequestValidationException("no data changes found");
        }
        customerDAO.updateCustomer(customer);
    }
}
