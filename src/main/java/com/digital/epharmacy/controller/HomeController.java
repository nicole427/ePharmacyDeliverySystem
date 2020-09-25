package com.digital.epharmacy.controller;
//Nicole Hawthonre - Home Controller class that waits for a web request
/*
*   Custom Landing Page
*   Opatile Kelobang
*   24 Spetember 2020
* */
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/")
public class HomeController {
    @GetMapping
    String home(){
        return "home";
    }
}

