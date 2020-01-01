package com.example.demo.test.dao;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name= "spring-cloud-producer",fallback = FeignClientFallback.class)
public interface RemoteDemo {
    //restful api 调用
    @GetMapping("/hello/{name}")
    public String hello(@PathVariable("name") String name);
}
