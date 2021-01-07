package com.gridgain.example.crud;

import org.apache.ignite.Ignite;
import org.apache.ignite.Ignition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}

	@Bean
	public Ignite ignite() {
		System.setProperty("IGNITE_QUIET","false");

		Ignition.setClientMode(true);

		return Ignition.start("config/ignite.xml");
	}

}
