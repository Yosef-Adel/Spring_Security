package com.example.spring_security.entity;

/*
 * @created 05/07/2023 - 1:01 PM
 * @project Spring_Security
 * @author Yosef Adel Mahmoud Saaid
 */

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "role")
@Setter @Getter  @NoArgsConstructor @ToString
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;
}
