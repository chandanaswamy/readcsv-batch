package com.importcsv.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.importcsv.entity.Customer;

@Component
public class CustomerDataProcessor implements ItemProcessor<Customer, Customer> {

    @Override
    public Customer process(Customer customer) {
        if (customer.getCompany().equalsIgnoreCase("Chile")) {
            throw new RuntimeException("Country should be Chile");
        }
        return customer;
    }
}
