package com.spring.childclinic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"child-clinic-data", "child-clinic-web"})
public class ChildClinicApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChildClinicApplication.class, args);
	}

}