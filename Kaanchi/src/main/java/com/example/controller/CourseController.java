package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.CourseDto;
import com.example.dto.StudentCourseDto;
import com.example.entity.Course;
import com.example.service.CourseService;

@RestController
@RequestMapping("/course")
public class CourseController {

  @Autowired
  private CourseService courseservice;
  
  
  @GetMapping
  public List<CourseDto> getall(){
    
    return courseservice.getallCourse();
  }
  
  @GetMapping("/{courseId}")
  public ResponseEntity<CourseDto> getById(@PathVariable Long courseId) {
    
   CourseDto course= courseservice.getcourseById(courseId);
    return new ResponseEntity<>(course,HttpStatus.OK);
    
  }
  
  
  @PostMapping
  public ResponseEntity<Course> save(@RequestBody Course course){
    
    Course cours=courseservice.savecourse(course);
    return new ResponseEntity<>(cours,HttpStatus.CREATED);
  }
  
  @PostMapping("/student/course")
  public ResponseEntity<Course> studentcourse(@RequestBody StudentCourseDto Scoursedto){
    
    Course course=courseservice.studentycourse(Scoursedto.getStudentId(),Scoursedto.getCourseId());
    return new ResponseEntity<>(course,HttpStatus.CREATED);
  }
  
  @DeleteMapping("/{courseId}")
  public void delete(@PathVariable Long courseId) {
    
    courseservice.deletecourse(courseId);
  }
}