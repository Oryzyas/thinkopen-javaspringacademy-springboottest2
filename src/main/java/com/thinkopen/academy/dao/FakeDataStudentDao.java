package com.thinkopen.academy.dao;

import com.thinkopen.academy.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class FakeDataStudentDao implements StudentDao {
    private static Map<Integer, Student> students;
    private static int lastId = 1;

    static {
        students = new HashMap<Integer, Student>() {
            {
                put(lastId, new Student(lastId++, "Said", "Computer Science"));
                put(lastId, new Student(lastId++, "Alex U", "Finance"));
                put(lastId, new Student(lastId++, "Anna", "Maths"));
            }
        };
    }

    @Override
    public Collection<Student> getAllStudents() {
        return students.values();
    }

    @Override
    public Collection<Student> insertStudents(Collection<Student> students) {
        for(Student s : students)
            insertStudent(s);

        return students;
    }

    @Override
    public Student insertStudent(Student student) {
        student.setId(lastId++);
        students.put(student.getId(), student);
        return student;
    }

    @Override
    public Student getStudentById(int id) {
        return students.get(id);
    }

    @Override
    public Student removeStudentById(int id) {
        return students.remove(id);
    }
}
