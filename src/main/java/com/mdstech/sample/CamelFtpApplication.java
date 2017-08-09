package com.mdstech.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by srini on 8/8/17.
 */
@SpringBootApplication
@EnableAutoConfiguration
public class CamelFtpApplication {
    public static void main(String[] args) {
        SpringApplication.run(CamelFtpApplication.class, args);
    }
}
