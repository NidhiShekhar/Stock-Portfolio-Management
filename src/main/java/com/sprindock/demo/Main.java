package com.sprindock.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.boot.jdbc.DataSourceBuilder;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// import javax.sql.DataSource;

@SpringBootApplication
@RestController

public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

	@GetMapping("/")
	public String greet(){
		return "Hello";
	}

//	@Configuration
//	public static class DataSourceConfig {
//		@Bean
//		public DataSource getDataSource() {
//			return DataSourceBuilder.create()
//					.driverClassName("org.postgresql.Driver")
//					.url("jdbc:postgresql://localhost:5432/customer_test")
//					.username("avimehta")
//					.password("12345678")
//					.build();
//		}
//	}

}
