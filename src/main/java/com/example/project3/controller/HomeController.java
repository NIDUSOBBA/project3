package com.example.project3.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "Welcome";
    }

    @GetMapping("/ot")
    public String ot() {
        return "Отдай сволочь!";
    }


}
