package com.example.demo.test.dao;

import org.springframework.stereotype.Component;

@Component
public class FeignClientFallback implements RemoteDemo {
    @Override
    public String hello(String name) {
        return "熔断器起作用了";
    }
}
