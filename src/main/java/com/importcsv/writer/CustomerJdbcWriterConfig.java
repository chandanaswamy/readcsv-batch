package com.importcsv.writer;

import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.importcsv.entity.Customer;

import javax.sql.DataSource;

@Configuration
public class CustomerJdbcWriterConfig {

    @SuppressWarnings("rawtypes")
	@Bean
    public JdbcBatchItemWriter<Customer> jdbcBatchItemWriter(DataSource dataSource) {
        JdbcBatchItemWriter<Customer> writer = new JdbcBatchItemWriter<>();
        writer.setDataSource(dataSource);
        writer.setSql("INSERT INTO employees (name, department, salary) VALUES (:name, :department, :salary)");
        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider());
        return writer;
    }
}