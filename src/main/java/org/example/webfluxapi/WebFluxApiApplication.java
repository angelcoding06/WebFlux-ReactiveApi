package org.example.webfluxapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebFluxApiApplication {

    private static final Logger log = LoggerFactory.getLogger(WebFluxApiApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(WebFluxApiApplication.class, args);
        log.info("Main: WebFluxApiApplication started");
    }

}
