package com.sch.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.sch.common.entity")
public class SchoolManagementSystemBackEndApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchoolManagementSystemBackEndApplication.class, args);
	}

}
