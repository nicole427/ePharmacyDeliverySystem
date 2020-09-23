package com.digital.epharmacy.controller;
//Nicole Hawthonre - Home Controller class that waits for a web request
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @RequestMapping("/")
    String home(){
        return "Electronic Pharmacy Delivery System Demo!!";
    }
}
