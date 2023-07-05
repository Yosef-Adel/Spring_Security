package com.example.spring_security;

import com.example.spring_security.entity.Role;
import com.example.spring_security.entity.User;
import com.example.spring_security.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner (UserService userService){
        return args -> {

            User user = new User("yosef", "pass");
            userService.addUser(user);

            userService.addRole(new Role("ROLE_ADMIN"));

            userService.attachRoleToUser("yosef","ROLE_ADMIN" );



        };
    }

}
