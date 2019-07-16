package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebFlux;

@SpringBootApplication(scanBasePackages = "com.example.demo",exclude = {DataSourceAutoConfiguration.class})
@EnableMongoRepositories(basePackages = "com.example.demo.repository")
@EnableSwagger2WebFlux
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
