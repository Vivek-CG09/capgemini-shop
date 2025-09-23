package com.cs.gateway.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderFallbackController {


    @RequestMapping("/fallback/orders")
    public ResponseEntity<String> fallback() {
        return new ResponseEntity<String>("Product Service is Down", HttpStatus.SERVICE_UNAVAILABLE);
    }
}
