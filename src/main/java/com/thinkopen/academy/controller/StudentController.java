package com.thinkopen.academy.controller;

import com.thinkopen.academy.entity.Student;
import com.thinkopen.academy.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.Collection;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
    public Collection<Student> getAllStudents(@PathVariable String name) {
        return studentService.getAllStudentsByName(name);
    }

    /*@RequestMapping(method = RequestMethod.POST)
    public Student insertStudent(@RequestBody Student student) {
        return studentService.insertStudent(student);
    }*/

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Student> insertStudents(@RequestBody Collection<Student> students) {
        return studentService.insertStudents(students);
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public Optional<Student> getStudentById(@PathVariable("id") int id) {
        return studentService.getStudentById(id);
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.DELETE)
    public void removeStudentById(@PathVariable("id") int id) {
        studentService.removeStudentById(id);
    }
}
