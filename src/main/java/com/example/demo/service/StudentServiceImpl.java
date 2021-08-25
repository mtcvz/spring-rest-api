package com.example.demo.service;

import com.example.demo.exception.StudentNotFoundException;
import com.example.demo.repository.StudentRepository;
import com.example.demo.student.Student;
import com.example.demo.student.StudentSearch;
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
public class StudentServiceImpl implements StudentService{

    @Autowired
    StudentRepository studentRepository;

    @Override
    public List<Student> getStudents(){
        return (List<Student>) studentRepository.findAll();
    }

    @Override
    public Optional<Student> getStudent(String id){
        if(!studentRepository.existsById(id)) throw new StudentNotFoundException("Student with id " + id + " not found.");
        return studentRepository.findById(id);
    }

/*
    public List<Student> getStudentsByGrade(int grade){
        return (List<Student>)studentRepository.findByGrade(grade);
    }

 */
    @Override
    public List<Student> getStudentsByGrade(int grade,int pageNo,int size){
        Pageable pageable = PageRequest.of(pageNo,size);
        return studentRepository.findByGrades(pageable,grade);
    }

    @Override
    public List<Student> getStudentsList(int pageNo, int size){
        Pageable pageable = PageRequest.of(pageNo,size);
        Page<Student> studentPage = studentRepository.findAll(pageable);
        return studentPage.toList();
    }

    @Override
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

    @Override
    public Iterable<Student> getStudentsSortedByBranch(String branch){
        Sort sort = Sort.by("mark");
        Iterable<Student> iterable = studentRepository.findAllByBranch(branch,sort.descending());
        return iterable;
    }

    @Override
    public Student addStudent(Student student){
        String id = UUID.randomUUID().toString();
        student.setId(id);
        studentRepository.save(student);
        return student;
    }

    @Override
    public void deleteStudent(String id){
        if(!studentRepository.existsById(id)) throw new StudentNotFoundException("Student with id " + id + " not found.");
        studentRepository.deleteById(id);
    }

    @Override
    public Student updateStudent(Student student,String id){
        if(!studentRepository.existsById(id)) throw new StudentNotFoundException("Student with id " + id + " not found.");
        student.setId(id);
        studentRepository.save(student);
        return student;
    }

    @Override
    public List<Student> getBestStudents(){
        return studentRepository.findBestStudents();
    }

    @Override
    public List<Student> searchStudents(StudentSearch studentSearch){
        return studentRepository.findStudents(studentSearch.getName(),studentSearch.getGrade(),
                studentSearch.getMinMark(),studentSearch.getMaxMark(),studentSearch.getBranch());
    }
}