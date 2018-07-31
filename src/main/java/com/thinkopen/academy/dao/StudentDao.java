package com.thinkopen.academy.dao;

import com.thinkopen.academy.entity.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface StudentDao {
    Collection<Student> getAllStudents();

    Collection<Student> insertStudents(Collection<Student> students);

    Student insertStudent(Student student);

    Student getStudentById(int id);

    Student removeStudentById(int id);
}
