package com.labhub;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LabHubApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(LabHubApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Refreshed");
		
	}

}
