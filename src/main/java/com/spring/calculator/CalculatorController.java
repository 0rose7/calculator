package com.spring.calculator;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

// Web kontroleris leidzia viduje naudoti @RequestMapping.
// @RestController anotacija nurodo , jog pvz: String tipo rezultatas turi buti ispaudinaas klientui toks koks yra
@RestController
// Zymi konfiguracijos komponenta viduje leidzia kurti bean per metodus su @Bean anotacija.
// Si klases lygio anotacija nurodo spring karkasui "Atspeti" konfiguracija.
// Rementis priklausomybemis ( Jar bibliotekomis ) kurios programuotojas itraukia i projekta ( Pom.xml
// Siuo atveju ji veikia kartu su main metodu.
@EnableAutoConfiguration
public class CalculatorController {
    @RequestMapping(method = RequestMethod.GET, value = "/")
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
