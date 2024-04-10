package com.spring.calculator;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;

// Web kontroleris leidzia viduje naudoti @RequestMapping.
// @RestController anotacija nurodo , jog pvz: String tipo rezultatas turi buti ispaudinaas klientui toks koks yra
@RestController
// Zymi konfiguracijos komponenta viduje leidzia kurti bean per metodus su @Bean anotacija.
// Si klases lygio anotacija nurodo spring karkasui "Atspeti" konfiguracija.
// Rementis priklausomybemis ( Jar bibliotekomis ) kurios programuotojas itraukia i projekta ( Pom.xml
// Siuo atveju ji veikia kartu su main metodu.
@EnableAutoConfiguration
public class CalculatorController {
    @RequestMapping(method = RequestMethod.GET, value = "/skaiciuoti")
    String hello() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        HelloWorld bean = (HelloWorld) context.getBean("HelloWorld");
        return bean.getHello();
    }
    String skaiciuoti(@RequestParam HashMap<String, String> skaiciai) {
        int sk1 = Integer.parseInt(skaiciai.get("sk1"));
        int sk2 = Integer.parseInt(skaiciai.get("sk2"));
        String zenklas = skaiciai.get("zenklas");

        int rezultatas = 0;
        if (zenklas.equals("+")) {
            rezultatas = sk1 + sk2;
        } else if (zenklas.equals("-")) {
            rezultatas = sk1 - sk2;
        } else if (zenklas.equals("*")) {
            rezultatas = sk1 * sk2;
        } else if (zenklas.equals("/")) {
            rezultatas = sk1 / sk2;
        }

        return sk1 + zenklas + sk2 + " = " + rezultatas;
    }

}