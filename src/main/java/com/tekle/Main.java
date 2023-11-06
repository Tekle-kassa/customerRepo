package com.tekle;

import com.tekle.customer.Customer;
import com.tekle.customer.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class,args);
    }
    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository){
        return args -> {
            Customer alex = new Customer(

                    "alex",
                    "alex@gmail.com",
                    23
            );
            Customer tekle = new Customer(

                    "tekle",
                    "tekle@gmail.com",
                    24
            );
            List<Customer> customers = List.of(alex, tekle);
            customerRepository.saveAll(customers);
        };
    }
}
