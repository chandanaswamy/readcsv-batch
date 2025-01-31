package com.importcsv.writer;

import org.springframework.batch.item.database.JpaItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.importcsv.entity.Customer;

import jakarta.persistence.EntityManagerFactory;
@Configuration
public class CustomerWriterConfig {
    @Bean
    public JpaItemWriter<Customer> jpaItemWriter(EntityManagerFactory entityManagerFactory) {
        JpaItemWriter<Customer> writer = new JpaItemWriter<>();
        writer.setEntityManagerFactory(entityManagerFactory);
        return writer;
    }
}
