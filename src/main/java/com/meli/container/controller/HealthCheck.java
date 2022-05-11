package com.meli.container.controller;

import com.meli.container.Utils.Messages;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheck {
    @GetMapping("/")
    public ResponseEntity<String> healthCheck(){
        return new ResponseEntity<>(Messages.HEALTHY_API, HttpStatus.OK);
    }
}
