package com.examplemarket;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greet")
public class HelloWorldController {

    @GetMapping("/greet")
    public String greet() {
        return "Hello World! 💻";
    }
}
