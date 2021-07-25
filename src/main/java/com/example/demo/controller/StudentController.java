package com.example.demo.controller;
import com.example.demo.exception.StudentNotFoundException;
import com.example.demo.student.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import javax.validation.Valid;

@RestController
@RequestMapping("/students")
public class StudentController {

    static HashMap<Integer, Student> studentsMap = new HashMap<Integer,Student>();
    static Integer id_counter = 0;
    Logger log = LoggerFactory.getLogger(StudentController.class);

    public void addStudent(String name,int age){
        log.info("[AddStudent] 'Add student' request was received.");
        id_counter++;
        studentsMap.put(id_counter,new Student(name,age));
    }

    @GetMapping
    public HashMap<Integer,Student> getStudents(){
        log.info("[GetStudents] 'Get students' request was received.");
        return studentsMap;
    }

    @GetMapping("/{index}")
    public Student getStudents(@PathVariable("index") int index){
        log.info("[GetStudents] 'Get student with index' request was received.");
        if(studentsMap.get(index) == null) throw new StudentNotFoundException("Student with id " + index + " not found.");
        return studentsMap.get(index);
    }

    @DeleteMapping("/{index}")
    public void deleteStudent(@PathVariable("index") int index){
        log.info("[DeleteStudent] 'Delete student' request was received.");
        if(studentsMap.get(index) == null) throw new StudentNotFoundException("Student with id " + index + " not found.");
        studentsMap.remove(index);
    }

    @PutMapping("/{index}/{name}/{age}")
    public void updateStudent(@PathVariable("index") int index,@PathVariable("name") String name,@PathVariable("age") int age){
        log.info("[UpdateStudent] 'Update student' request was received.");
        if(studentsMap.get(index) == null) throw new StudentNotFoundException("Student with id " + index + " not found.");
        studentsMap.get(index).setName(name);
        studentsMap.get(index).setAge(age);
    }

    @PostMapping("/{name}/{age}")
    public void postStudent(@Valid @PathVariable("name") String name,@PathVariable("age") int age){
        log.info("[PostStudent] 'Post student' request was received.");
        id_counter++;
        studentsMap.put(id_counter,new Student(name,age));
    }
}
