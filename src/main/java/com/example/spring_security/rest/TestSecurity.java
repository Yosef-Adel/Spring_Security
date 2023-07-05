package com.example.spring_security.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * @created 05/07/2023 - 2:05 PM
 * @project Spring_Security
 * @author Yosef Adel Mahmoud Saaid
 */
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class TestSecurity {

    @GetMapping()
    public String allUsers(){
        return "All User ";
    }

    @GetMapping("/manager")
    public String manager(){
        return " manager ";
    }

    @GetMapping("/admin")
    public String admin(){
        return " admin ";
    }



}
