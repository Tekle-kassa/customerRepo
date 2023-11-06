package com.tekle;

import com.tekle.customer.CustomerController;
import com.tekle.customer.CustomerDataAccessService;
import com.tekle.customer.CustomerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
//        System.out.println(customers);
        /*
        CustomerService customerService=new CustomerService(new CustomerDataAccessService());
        CustomerController customerController=new CustomerController(customerService);
        */
        SpringApplication.run(Main.class,args);
    }
}
