package com.miko.paopao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class PaopaoApplication {

    public static void main(String[] args) {
        SpringApplication.run(PaopaoApplication.class, args);
    }

}
