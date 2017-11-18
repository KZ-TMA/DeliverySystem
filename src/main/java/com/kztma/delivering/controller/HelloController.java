package com.kztma.delivering.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by cccc on 11/18/2017.
 */

@RestController
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping(method = RequestMethod.GET)
    public String hello(){
        return "Hello ";
    }

    @RequestMapping(value ="/{name}", method = RequestMethod.GET)
    public String hello(@PathVariable(name = "name") String name){
        return "Hello " + name;
    }

}
