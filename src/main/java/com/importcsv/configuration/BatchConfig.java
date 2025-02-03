package com.importcsv.configuration;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.database.JpaItemWriter;
import org.springframework.batch.item.database.builder.JpaItemWriterBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import com.importcsv.csvreader.CsvUtility;
import com.importcsv.entity.Customer;
import com.importcsv.processor.CustomerDataProcessor;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

    private  JobRepository jobRepository;
    private  PlatformTransactionManager transactionManager;
    private  EntityManagerFactory entityManagerFactory;
    private  CsvUtility reader;
    private  CustomerDataProcessor processor;

    public BatchConfig(JobRepository jobRepository,
                          PlatformTransactionManager transactionManager,
                          EntityManagerFactory entityManagerFactory,
                          CsvUtility reader,
                          CustomerDataProcessor processor) {
        this.jobRepository = jobRepository;
        this.transactionManager = transactionManager;
        this.entityManagerFactory = entityManagerFactory;
        this.reader = reader;
        this.processor = processor;
    }

    @Bean
    public JpaItemWriter<Customer> writer() {
        return new JpaItemWriterBuilder<Customer>()
                .entityManagerFactory(entityManagerFactory)
                .build();
    }

    @Bean
    public Step customerStep() {
        return new StepBuilder("customerStep", jobRepository)
                .<Customer, Customer>chunk(5, transactionManager)
                .reader(reader)
                .processor(processor)
                .writer(writer())
                .build();
    }

    @Bean
    public Job customerJob() {
        return new JobBuilder("customerJob",jobRepository)
                .start(customerStep())
                .build();
    }
}







