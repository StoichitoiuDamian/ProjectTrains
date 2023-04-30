package com.example.demo;

import com.example.demo.controller.PersonController;
import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import com.example.demo.unittests.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication{

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		double val;
		double val2;
		CalculDobanda c1 = new CalculDobanda();
		val = c1.dobanda(TypeDobanda.MARE);
		System.out.println(val);

		OperatiiBazaDeDate c3 = new OperatiiBazaDeDateMoc();
		val2 = c1.returneazaDobanda(c3.getUser());
		System.out.println(val2);

		CalculDobanda dobandaNoua = new CalculDobanda(c3);
		System.out.println(dobandaNoua.calculDobanda());
	}


}
