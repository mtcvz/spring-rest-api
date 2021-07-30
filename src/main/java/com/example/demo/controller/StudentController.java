package com.example.demo.controller;
import com.example.demo.student.Student;
import com.example.demo.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/students")
public class StudentController {

    Logger log = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    StudentService studentService;

    @GetMapping
    public ResponseEntity<Student> getStudents(){
        log.info("[GetStudents] 'Get students' request was received.");
        return new ResponseEntity(studentService.getStudents(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable("id") String id){
        log.info("[GetStudents] 'Get student with id' request was received.");
        return new ResponseEntity(studentService.getStudent(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable("id") String id){
        log.info("[DeleteStudent] 'Delete student' request was received.");
        studentService.deleteStudent(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@Valid @RequestBody Student student,@PathVariable String id){
        log.info("[UpdateStudent] 'Update student' request was received.");
        return new ResponseEntity(studentService.updateStudent(student,id),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Student> postStudent(@Valid @RequestBody Student student){
        log.info("[PostStudent] 'Post student' request was received.");
        return new ResponseEntity(studentService.addStudent(student),HttpStatus.OK);
    }
}