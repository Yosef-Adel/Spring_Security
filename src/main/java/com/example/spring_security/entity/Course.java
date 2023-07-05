package com.example.spring_security.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
 * @created 05/07/2023 - 5:53 PM
 * @project Spring_Security
 * @author Yosef Adel Mahmoud Saaid
 */
@Entity
@Table(
        name = "course"
)
@Setter
@Getter
@NoArgsConstructor
@ToString
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;

    public Course(String name) {
        this.name = name;
    }


}
