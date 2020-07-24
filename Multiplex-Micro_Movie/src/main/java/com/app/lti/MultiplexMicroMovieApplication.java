package com.app.lti;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;



@SpringBootApplication
@EnableDiscoveryClient
public class MultiplexMicroMovieApplication {

	public static void main(String[] args) {
		SpringApplication.run(MultiplexMicroMovieApplication.class, args);
		
		System.out.println("Started Movie Microservice");
	}

}
