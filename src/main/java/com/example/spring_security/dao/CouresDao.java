package com.example.spring_security.dao;

import com.example.spring_security.entity.Course;

import java.util.List;

/*
 * @created 05/07/2023 - 6:09 PM
 * @project Spring_Security
 * @author Yosef Adel Mahmoud Saaid
 */
public interface CouresDao {
    List<Course> getAllCourses();

    Course addCourse(Course course);

    Course updateCourse( Course course);
}
