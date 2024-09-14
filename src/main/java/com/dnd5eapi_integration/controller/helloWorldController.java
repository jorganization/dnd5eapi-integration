package com.dnd5eapi_integration.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
@Slf4j
public class helloWorldController {
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public String helloWorld() {
        String greeting = "Hello World!";
        log.info(greeting);
        return greeting;
    }

    @GetMapping(value = "/{name}")
    @ResponseStatus(HttpStatus.OK)
    public String helloName(@PathVariable("name") String name) {
        String greeting = "Hello " + name;
        log.info(greeting);
        return greeting;
    }

}
