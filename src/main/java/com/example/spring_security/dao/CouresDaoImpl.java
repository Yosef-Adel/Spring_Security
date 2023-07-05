package com.example.spring_security.dao;

import com.example.spring_security.entity.Course;
import com.example.spring_security.repo.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
 * @created 05/07/2023 - 6:10 PM
 * @project Spring_Security
 * @author Yosef Adel Mahmoud Saaid
 */
@Repository
@RequiredArgsConstructor
public class CouresDaoImpl implements CouresDao{
    private final CourseRepository courseRepository;
    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course updateCourse(Course course) {
        return courseRepository.save(course);
    }
}
