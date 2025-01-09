package com.gcu.topic22;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@ComponentScan({ "com.gcu", "com.gcu.data.repository"})
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableMongoRepositories(basePackages = "com.gcu.data.repository")
public class Topic42Application {

    public static void main(String[] args) {
        SpringApplication.run(Topic42Application.class, args);
    }

}
