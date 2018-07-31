package com.thinkopen.academy.service;

import com.thinkopen.academy.entity.Student;
import com.thinkopen.academy.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepo;

    public Collection<Student> getAllStudentsByName(String name){return studentRepo.findStudentsByName(name);}

    public Collection<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    public Optional<Student> getStudentById(int id) {
        return studentRepo.findById(id);
    }

    public Student insertStudent(Student student) {
        return studentRepo.save(student);
    }

    public Collection<Student> insertStudents(Collection<Student> students) {
        return studentRepo.saveAll(students);
    }

    public void removeStudentById(int id) {
        studentRepo.deleteById(id);
    }
}
