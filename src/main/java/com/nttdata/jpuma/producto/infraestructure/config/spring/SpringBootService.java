package com.nttdata.jpuma.producto.infraestructure.config.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

//@SpringBootApplication
@SpringBootApplication(scanBasePackages = "com.nttdata.jpuma.producto.infraestructure")
@EntityScan(basePackages = "com.nttdata.jpuma.producto.domain")
public class SpringBootService {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootService.class, args);
	}

}
