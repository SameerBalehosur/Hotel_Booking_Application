package com.testyantra.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
/**
 * @author Sameer Balehosur
 *
 */
@SpringBootApplication
public class UserHotelBookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserHotelBookingApplication.class, args);
	}
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
