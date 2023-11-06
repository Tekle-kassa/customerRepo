package com.tekle.customer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.tekle.customer.CustomerDataAccessService.customers;

@RestController
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("api/v1/customers")
    /*
    @RequestMapping(path ="/api/v1/customers",
            method = RequestMethod.GET)

     */
    public List<Customer> getCustomers(){
        return customerService.getAllCustomers();
    }
    @GetMapping("api/v1/customers/{customerId}")
    public Customer getCustomer(@PathVariable("customerId")Integer customerId){
         return customerService.getCustomer(customerId);
    }

}
