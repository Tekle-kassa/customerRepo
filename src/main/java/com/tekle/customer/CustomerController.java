package com.tekle.customer;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    /*
    @RequestMapping(path ="/api/v1/customers",
            method = RequestMethod.GET)

     */
    public List<Customer> getCustomers(){
        return customerService.getAllCustomers();
    }
    @GetMapping("/{customerId}")
    public Customer getCustomer(@PathVariable("customerId")Integer customerId){
         return customerService.getCustomer(customerId);
    }
    @PostMapping
    public void registerCustomer(@RequestBody RegistrationRequest request){
        customerService.addCustomer(request);
    }
    @DeleteMapping("/{customerId}")
    public void deleteCustomer(@PathVariable("customerId")Integer customerId){
        customerService.deleteCustomerById(customerId);
    }
    @PutMapping("/{customerId}")
    public void updateCustomer(@PathVariable("customerId")Integer customerId,@RequestBody RegistrationRequest request){
        customerService.updateCustomer(customerId,request);
    }

}
