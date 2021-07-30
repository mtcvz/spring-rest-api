package com.example.demo.service;

import com.example.demo.exception.StudentNotFoundException;
import com.example.demo.student.Student;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.UUID;

@Service
public class StudentService {

    static HashMap<String, Student> studentsMap = new HashMap<String,Student>();

    public HashMap<String,Student> getStudents(){
        return studentsMap;
    }

    public Student getStudent(String id){
        if(studentsMap.get(id) == null) throw new StudentNotFoundException("Student with id " + id + " not found.");
        return studentsMap.get(id);
    }

    public Student addStudent(Student student){
        String id = UUID.randomUUID().toString();
        student.setId(id);
        studentsMap.put(id,student);
        return student;
    }

    public void deleteStudent(String id){
        if(studentsMap.get(id) == null) throw new StudentNotFoundException("Student with id " + id + " not found.");
        studentsMap.remove(id);
    }

    public Student updateStudent(Student student,String id){
        if(studentsMap.get(id) == null) throw new StudentNotFoundException("Student with id " + id + " not found.");
        student.setId(id);
        studentsMap.put(id,student);
        return student;
    }
}
