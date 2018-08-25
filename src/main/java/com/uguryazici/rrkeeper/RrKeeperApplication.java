package com.uguryazici.rrkeeper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.uguryazici.rrkeeper.entity")
@EnableJpaRepositories(basePackages = "com.uguryazici.rrkeeper.repository")
public class RrKeeperApplication {

    public static void main(String[] args) {
        SpringApplication.run(RrKeeperApplication.class, args);
    }
}
