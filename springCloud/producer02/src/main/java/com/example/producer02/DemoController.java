package com.example.producer02;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    //restful api方式
    @GetMapping("/hello/{name}")
    public String index(@PathVariable String name){

        return "hello!端口：9001" + name;
    }
}
