package com.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/***
 * 
 * @project Multi-Ticket Booking
 * @author shubh-sinha
 * 
 *
 */
@EnableDiscoveryClient
@SpringBootApplication
public class UserOrderAPIGatewatApplication {

	RestTemplate rt;

	public static void main(String[] args) {
		SpringApplication.run(UserOrderAPIGatewatApplication.class, args);

	}
	
	@LoadBalanced
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
