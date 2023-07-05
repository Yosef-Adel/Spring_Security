package com.example.spring_security.rest;

/*
 * @created 05/07/2023 - 6:33 PM
 * @project Spring_Security
 * @author Yosef Adel Mahmoud Saaid
 */

import com.example.spring_security.entity.User;
import com.example.spring_security.security.JwtUtil;
import com.example.spring_security.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    private final UserService userService;

    @PostMapping("/signup")
    public User createUser( @RequestBody User user ){
        return userService.addUser(user);
    }



    @PostMapping("login")
    public ResponseEntity<String> authenticate(
            @RequestBody User requset
    ){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(requset.getUserName(), requset.getPassword())
        );

        final User user = userService.findByUserName(requset.getUserName());

        if(user!= null){
            return ResponseEntity.ok(jwtUtil.generateToken(user));
        }
        return ResponseEntity.status(400).body("ERORRRRRRRRRRRR");
    }
}



