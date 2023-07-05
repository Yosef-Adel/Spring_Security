package com.example.spring_security.rest;

import com.example.spring_security.entity.Course;
import com.example.spring_security.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 * @created 05/07/2023 - 6:47 PM
 * @project Spring_Security
 * @author Yosef Adel Mahmoud Saaid
 */
@RestController
@RequestMapping("/courses")
@RequiredArgsConstructor
public class CourseController {

    private  final  CourseService courseService ;

    @PostMapping
    public Course addCourse(@RequestBody Course course){
        return courseService.addCourse(course);
    }

    @GetMapping
    public List<Course> getAllCourses(){
        return courseService.getAllCourses();
    }

    @GetMapping("{id}")
    public Course getCourseById(@PathVariable("id") Long id){
        return courseService.getCourseByID(id);
    }

    @DeleteMapping("{id}")
    public String deleteCourse(@PathVariable("id") Long id){
        courseService.deleteCourse(id);
        return "Cousre With ID [%s] is Deleted".formatted(id);
    }

    @PutMapping("{id}")
    public Course updateCourse( @RequestBody Course course ,
                                @PathVariable("id") Long id)
    {
        course.setId(id);
        return courseService.updateCourse(course);
    }


}
