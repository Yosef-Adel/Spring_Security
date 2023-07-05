package com.example.spring_security.repo;

import com.example.spring_security.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

/*
 * @created 05/07/2023 - 6:07 PM
 * @project Spring_Security
 * @author Yosef Adel Mahmoud Saaid
 */
public interface CourseRepository extends JpaRepository<Course, Long> {
}
