package com.petshop.application;

//import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.petshop.sql.DbConnection;

@SpringBootApplication
public class Program {

	public static void main(String[] args) {

		// SpringApplication.run(Program.class, args);

		DbConnection conn = new DbConnection();
		conn.getConnection();

		if (conn != null) {
			System.out.println("deu certo");
		} else{
			System.out.println("deu ruim");

		}

	}

}
