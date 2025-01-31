package com.importcsv.csvreader;

import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Component;

import com.importcsv.entity.Customer;

@Component
public class CsvUtility extends FlatFileItemReader<Customer> {

    public CsvUtility() {
        setResource(new FileSystemResource("src/main/resources/customer.csv"));
        setLinesToSkip(1); // Skip header

        setLineMapper(new DefaultLineMapper<>() {{
            setLineTokenizer(new DelimitedLineTokenizer() {{
                setNames("Index", "Customer Id", "First Name","Last Name","Company","City","Country","Phone 1","Phone 2","Email","Subscription Date","Website");
            }});
            setFieldSetMapper(new BeanWrapperFieldSetMapper<>() {{
                setTargetType(Customer.class);
            }});
        }});
    }
}
