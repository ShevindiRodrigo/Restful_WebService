package com.example.restfulWebService_app;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
    public static final String template = "Hello %s";
    public final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name",defaultValue="World")String name){
        return new Greeting(counter.incrementAndGet(),String.format(template,name));
    }
}