package com.wisdom.bevm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PollingCenterController {

    @GetMapping("/polling-centers")
    public String homePage(){
        return "polling-center";
    }

}
