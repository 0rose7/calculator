package com.spring.calculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// @SpringBootApplication anotacija yra lygi @Configuration, @EnableAutoConfiguration ir @ComponentScan
// Nurodoma klasėje, turinčioje pagrindinį (main) metodą.
@SpringBootApplication
// WEB Kontroleris. Pažymi MVC valdiklį. Leidžia viduje naudoti @RequestMapping
// @RestController anotacija nurodo, jog String tipo rezultatas turėtų būti išspausdinamas klientui toks koks yra.
@RestController

public class CalculatorApplication {
	public static void main(String[] args) {
		SpringApplication.run(CalculatorApplication.class, args);
		System.out.println("Woohoo pirmoji spring boot aplikacija");
	}
	// http://localhost:8080/hello?name=Andrius&surname=Nizevicius
	// Metodo pavadinimas klaustukas (?) raktas, lygybe, reiksme, Optional jeigu daugiau &
	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name" , defaultValue = "World") String name, int age) {
		return "Hello " + name + " metai: " + age;
	}
	@GetMapping("/index")
	public String index() {
		return "<h1>Internetinis Skaiciuotuvas. Atliks operacijas:</h1><br>" +
		"&nbsp;&nbsp; Atimti<br>" +
		"&nbsp;&nbsp; Dalinti<br>" +
		"&nbsp;&nbsp; Sudeti<br>" +
		"&nbsp;&nbsp; Dauginti<br>" +
		"&nbsp;&nbsp; Atimti<br>";

	}

}
