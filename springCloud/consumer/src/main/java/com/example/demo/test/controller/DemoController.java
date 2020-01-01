package com.example.demo.test.controller;

import com.example.demo.test.dao.RemoteDemo;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Configurable

public class DemoController {
    @Autowired
    RemoteDemo remoteDemo;
    @Autowired
    RestTemplate restTemplate;


    @GetMapping("/hello/{name}")
    public String index(@PathVariable("name") String name) {
        return remoteDemo.hello(name);
    }

    @HystrixCommand(fallbackMethod = "ribbonDefault")
    @GetMapping("/helloRibbon/{name}")
    public String helloRibbon(@PathVariable("name") String name) {
        String result = restTemplate.getForObject("http://spring-cloud-producer/hello/"+name, String.class);
        return result;
    }
    private String ribbonDefault(@PathVariable("name") String name) {
        System.out.println("熔断，默认回调函数");
        return "熔断，默认回调函数";
    }
}
