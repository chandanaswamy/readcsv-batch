package com.importcsv.configuration;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.importcsv.entity.Customer;

@Configuration
public class BatchConfig {

    private final JobBuilder jobBuilderFactory;
    private final StepBuilder stepBuilderFactory;

    public BatchConfig(JobBuilder jobBuilderFactory, StepBuilder stepBuilderFactory) {
        this.jobBuilderFactory = jobBuilderFactory;
        this.stepBuilderFactory = stepBuilderFactory;
    }

    @Bean
    public Step employeeStep(ItemReader<Customer> reader, 
                             ItemProcessor<Customer, Customer> processor, 
                             ItemWriter<Customer> writer) {
        return stepBuilderFactory.get("customerStep")
                .<Customer, Customer>chunk(10) // Batch size
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .faultTolerant()
                .skip(Exception.class)
                .skipLimit(5)
                .build();
    }
    

    @Bean
    public Job employeeJob(Step customerStep) {
        return jobBuilderFactory.get("customerJob")
                .start(customerStep)
                .build();
    }
}
