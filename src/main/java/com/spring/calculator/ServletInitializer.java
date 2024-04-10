package com.spring.calculator;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
// Servlet yra Java programa, veikianti WEB serveryje.
// SErvlet paleidziamas, kai vartotojas spusteleja nuoroda, pateikia forma ar atlieka kito tipo veiksmus svetaineje.
// Kiekvienas kliento request'as praeina per Servlet, kuris ji perduoda Controller'io RequestMapping atributui.
public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(CalculatorApplication.class);
	}

}
