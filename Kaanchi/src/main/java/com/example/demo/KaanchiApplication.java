package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.example.entity")
@ComponentScan(basePackages={"com.example.service,com.example.controller,com.example.config"})
@EnableJpaRepositories("com.example.repository")
@EnableAutoConfiguration
public class KaanchiApplication {

	public static void main(String[] args) {
		SpringApplication.run(KaanchiApplication.class, args);
	}

}
