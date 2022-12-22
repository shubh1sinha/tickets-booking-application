package com.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/***
 * 
 * @author shubh-sinha
 * @project Multi-tour-booking
 *
 */
@EnableDiscoveryClient
@SpringBootApplication
public class UserTrainMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserTrainMicroserviceApplication.class, args);

	}

}
