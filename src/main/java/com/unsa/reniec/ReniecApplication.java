package com.unsa.reniec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ReniecApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReniecApplication.class, args);
	}

}
