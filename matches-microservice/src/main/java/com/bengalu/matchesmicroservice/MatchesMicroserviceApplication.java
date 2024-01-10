package com.bengalu.matchesmicroservice;

import com.bengalu.matchesmicroservice.services.loadTestData.CsvReader;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.sql.SQLException;

@SpringBootApplication
public class MatchesMicroserviceApplication {

	@Autowired
	private CsvReader loadDb;

	public static void main(String[] args) {
		SpringApplication.run(MatchesMicroserviceApplication.class, args);
	}

	@PostConstruct
	public void init() throws SQLException, IOException {
		//this.loadDb.load();
	}
}
