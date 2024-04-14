package com.spring.calculator;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;



@Controller

//@EnableAutoConfiguration
public class CalculatorController {

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String home(Model model) {

        model.addAttribute("number", new Number());

        return "calculator";
    }

    // kadangi skaiciuotuvo fomra naudoja POST metoda, cia irgi nurodome POST.
    @PostMapping("/calculate")
    String calculate(@Valid @ModelAttribute("number") Number e, BindingResult br,
                     @RequestParam HashMap<String, String> numbers, ModelMap modelMap) {
        if (br.hasErrors()) {
            return "calculator";
        } else {
            int num1 = Integer.parseInt(numbers.get("num1"));
            int num2 = Integer.parseInt(numbers.get("num2"));
            String operation = numbers.get("opreation");

            System.out.println("Results: " + numbers.entrySet());

            int result = 0;

            if (operation.equals("+")) {
                result = num1 + num2;
            } else if (operation.equals("-")) {
                result = num1 - num2;
            } else if (operation.equals("*")) {
                result = num1 * num2;
            } else if (operation.equals("/")) {
                result = num1 / num2;
            }

            modelMap.put("num1", num1);
            modelMap.put("num2", num2);
            modelMap.put("operation", operation);
            modelMap.put("result", result);

            return "calculate";
        }
    }
}