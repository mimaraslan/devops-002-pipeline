package com.mimaraslan.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;


//  http://localhost:8081
@RestController
@RequestMapping
public class DevOpsController {

    //  http://localhost:8081
    @GetMapping
    public String devopsHello() {
        return "DevOps Hello : " + LocalDateTime.now();
    }

    //  http://localhost:8081/info
    @GetMapping("/info")
    public String info() {
        return "DEVOPS INFO : " + LocalDateTime.now();
    }

}
