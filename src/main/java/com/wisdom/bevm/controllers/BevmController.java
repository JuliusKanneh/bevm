package com.wisdom.bevm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BevmController {

    @GetMapping("/bevms")
    public String homePage(){
        return "bevm";
    }

}
