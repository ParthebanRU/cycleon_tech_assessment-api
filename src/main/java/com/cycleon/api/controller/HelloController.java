package com.cycleon.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/")
    public ResponseEntity<String> testApp() {
        return new ResponseEntity<>("App is alive", HttpStatus.OK);
    }
}
