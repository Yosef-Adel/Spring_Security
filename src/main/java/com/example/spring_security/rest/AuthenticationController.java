package com.example.spring_security.rest;

/*
 * @created 05/07/2023 - 6:33 PM
 * @project Spring_Security
 * @author Yosef Adel Mahmoud Saaid
 */

import com.example.spring_security.entity.User;
import com.example.spring_security.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final UserService userService;

    @PostMapping("/signup")
    public User createUser( @RequestBody User user ){
        return userService.addUser(user);
    }


}
