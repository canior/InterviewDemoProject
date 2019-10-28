package com.carriersedge.demo;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;

import com.carriersedge.demo.service.DummyDataService;

@SpringBootApplication
@EnableAutoConfiguration(exclude=HibernateJpaAutoConfiguration.class)
public class CarriersEdgeDemoApplication {

	@Autowired
	private DummyDataService dummyDataService;
	
	public static void main(String[] args) {
		SpringApplication.run(CarriersEdgeDemoApplication.class, args);
	}
	
	/**
	 * This is a dummy function to create some test data for the demo
	 */
	@Bean
	InitializingBean createDummyData() {
		return () -> {
			dummyDataService.createLocations();
			dummyDataService.createCurriculums();
			dummyDataService.createCarrier();
			dummyDataService.createAdminUser();
			dummyDataService.createUser();
			dummyDataService.createLocationCurriculums();
	      };
	}
	
}
