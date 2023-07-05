package com.example.spring_security.service;

import com.example.spring_security.dao.CouresDao;
import com.example.spring_security.entity.Course;
import com.example.spring_security.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/*
 * @created 05/07/2023 - 6:25 PM
 * @project Spring_Security
 * @author Yosef Adel Mahmoud Saaid
 */
@Service
@RequiredArgsConstructor
public class CourseService {
    private final CouresDao couresDao;

    public List<Course> getAllCourses(){
        return couresDao.getAllCourses();
    }

    public Course addCourse(Course course){
        return couresDao.addCourse(course);
    }

    public  Course updateCourse(Course course){
        return couresDao.updateCourse(course);
    }

    public Course getCourseByID(Long id){
        return couresDao.getCourseByID(id).orElseThrow(()-> new ResourceNotFoundException("Course with id [%s] not found".formatted(id)));
    }

    public void deleteCourse(Long id){
        couresDao.deleteCourse(id);
    }
}
