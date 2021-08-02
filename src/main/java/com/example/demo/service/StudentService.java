package com.example.demo.service;

import com.example.demo.exception.StudentNotFoundException;
import com.example.demo.repository.StudentRepository;
import com.example.demo.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StudentService {

    static HashMap<String, Student> studentsMap = new HashMap<String,Student>();

    @Autowired
    StudentRepository studentRepository;

    public List<Student> getStudents(){
        return (List<Student>) studentRepository.findAll();
    }

    public Optional<Student> getStudent(String id){
        if(!studentRepository.existsById(id)) throw new StudentNotFoundException("Student with id " + id + " not found.");
        return studentRepository.findById(id);
    }

    public Student addStudent(Student student){
        String id = UUID.randomUUID().toString();
        student.setId(id);
        studentRepository.save(student);
        return student;
    }

    public void deleteStudent(String id){
        if(!studentRepository.existsById(id)) throw new StudentNotFoundException("Student with id " + id + " not found.");
        studentRepository.deleteById(id);
    }

    public Student updateStudent(Student student,String id){
        if(!studentRepository.existsById(id)) throw new StudentNotFoundException("Student with id " + id + " not found.");
        student.setId(id);
        studentRepository.save(student);
        return student;
    }
}
