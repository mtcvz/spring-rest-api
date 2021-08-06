package com.example.demo.controller;
import com.example.demo.student.Student;
import com.example.demo.service.StudentService;
import com.fasterxml.jackson.databind.node.ObjectNode;
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

    @GetMapping("/search=sorted")
    public ResponseEntity<Student> getStudentsSorted(){
        log.info("[GetStudentsSorted] 'Get Students Sorted' request was received.");
        return new ResponseEntity(studentService.getStudentsSorted(),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable("id") String id){
        log.info("[DeleteStudent] 'Delete student' request was received.");
        studentService.deleteStudent(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@Valid @RequestBody Student student, @PathVariable String id){
        log.info("[UpdateStudent] 'Update student' request was received.");
        return new ResponseEntity(studentService.updateStudent(student,id),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Student> postStudent(@Valid @RequestBody Student student){
        log.info("[PostStudent] 'Post student' request was received.");
        return new ResponseEntity(studentService.addStudent(student),HttpStatus.OK);
    }

    @PostMapping("/search=grade")
    public ResponseEntity<Student> getStudentsByGrade(@RequestBody int grade){
        log.info("[GetStudentByGrade] 'Get Students By Grade' request was received.");
        return new ResponseEntity(studentService.getStudentsByGrade(grade),HttpStatus.OK);
    }

    @PostMapping("/search=branch")
    public ResponseEntity<Student> getStudentsByBranch(@RequestBody String branch){
        log.info("[GetStudentByBranch] 'Get Students By Branch' request was received.");
        return new ResponseEntity(studentService.getStudentsByBranch(branch),HttpStatus.OK);
    }

    @PostMapping("/search=grade&branch")
    public ResponseEntity<Student> getStudentsByGradeAndBranch(@RequestBody ObjectNode objectNode){
        log.info("[GetStudentByGradeAndBranch] 'Get Students By Grade and Branch' request was received.");
        return new ResponseEntity(studentService.getStudentsByGradeAndBranch(objectNode.get("grade").intValue(),objectNode.get("branch").asText()),HttpStatus.OK);
    }

    @PostMapping("/search=page")
    public ResponseEntity<Student> getStudentPages(@RequestBody ObjectNode objectNode){
        log.info("[GetStudentPages] 'Get Student Pages' request was received.");
        return new ResponseEntity(studentService.getStudentsList(objectNode.get("page").intValue(),objectNode.get("size").intValue()),HttpStatus.OK);
    }

    @PostMapping("/search=sorted&grade")
    public ResponseEntity<Student> getStudentsSortedByGrade(@RequestBody int grade){
        log.info("[GetStudentsSortedByGrade] 'Get Students Sorted By Grade' request was received.");
        return new ResponseEntity(studentService.getStudentsSortedByGrade(grade),HttpStatus.OK);
    }

    @PostMapping("/search=sorted&branch")
    public ResponseEntity<Student> getStudentsSortedByBranch(@RequestBody String branch){
        log.info("[GetStudentsSortedByBranch] 'Get Students Sorted By Branch' request was received.");
        return new ResponseEntity(studentService.getStudentsSortedByBranch(branch),HttpStatus.OK);
    }
}