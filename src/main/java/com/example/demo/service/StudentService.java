package com.example.demo.service;

import com.example.demo.exception.StudentNotFoundException;
import com.example.demo.repository.StudentRepository;
import com.example.demo.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public List<Student> getStudents(){
        return (List<Student>) studentRepository.findAll();
    }

    public Optional<Student> getStudent(String id){
        if(!studentRepository.existsById(id)) throw new StudentNotFoundException("Student with id " + id + " not found.");
        return studentRepository.findById(id);
    }

    public List<Student> getStudentsByGrade(int grade){
        return (List<Student>)studentRepository.findByGrade(grade);
    }

    public List<Student> getStudentsByBranch(String branch){
        return (List<Student>)studentRepository.findByBranch(branch);
    }

    public List<Student> getStudentsByGradeAndBranch(int grade,String branch){
        return (List<Student>) studentRepository.findByGradeAndAndBranch(grade,branch);
    }

    public List<Student> getStudentsList(int pageNo, int size){
        Pageable pageable = PageRequest.of(pageNo,size);
        Page<Student> studentPage = studentRepository.findAll(pageable);
        return studentPage.toList();
    }

    public Iterable<Student> getStudentsSorted(){
        Sort sort = Sort.by("mark");
        Iterable<Student> iterable = studentRepository.findAll(sort.descending());
        return iterable;
    }

    public Iterable<Student> getStudentsSortedByGrade(int grade){
        Sort sort = Sort.by("mark");
        Iterable<Student> iterable = studentRepository.findAllByGrade(grade,sort.descending());
        return iterable;
    }

    public Iterable<Student> getStudentsSortedByBranch(String branch){
        Sort sort = Sort.by("mark");
        Iterable<Student> iterable = studentRepository.findAllByBranch(branch,sort.descending());
        return iterable;
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