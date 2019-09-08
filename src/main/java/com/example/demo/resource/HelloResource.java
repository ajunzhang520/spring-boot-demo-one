package com.example.demo.resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/rest/1.0/hello")
public class HelloResource {

    @RequestMapping(value = "/{firstName}", method = RequestMethod.GET)
    public String sayHello(@PathVariable("firstName") String firstName) {
        return String.format("hello %s", firstName);
    }

    @RequestMapping(value = "/springboot", method = RequestMethod.GET)
    public String hello() {
        return "hello";
    }


}
