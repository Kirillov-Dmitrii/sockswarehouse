package com.skypro.sockswarehouse;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition
public class SockswarehouseApplication {
	public static void main(String[] args) {
		SpringApplication.run(SockswarehouseApplication.class, args);
	}
}
