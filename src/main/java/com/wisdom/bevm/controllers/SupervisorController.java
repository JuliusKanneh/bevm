package com.wisdom.bevm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SupervisorController {

    @GetMapping("/supervisors")
    public String homePage(){
        return "supervisor";
    }

}
