package com.s2e.tecnicalinterview;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class TecnicalInterviewApplication {

	public static void main(String[] args) {
		SpringApplication.run(TecnicalInterviewApplication.class, args);
	}

}
