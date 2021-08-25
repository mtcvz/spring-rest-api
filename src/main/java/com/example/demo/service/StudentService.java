package com.example.demo.service;

import com.example.demo.student.Student;
import com.example.demo.student.StudentSearch;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    Student addStudent(Student student);
    void deleteStudent(String id);
    Student updateStudent(Student student,String id);
    List<Student> getStudents();
    Optional<Student> getStudent(String id);
    List<Student> getStudentsByGrade(int grade,int pageNo,int size);
    List<Student> getStudentsList(int pageNo, int size);
    Iterable<Student> getStudentsSorted();
    Iterable<Student> getStudentsSortedByGrade(int grade);
    Iterable<Student> getStudentsSortedByBranch(String branch);
    List<Student> getBestStudents();
    List<Student> searchStudents(StudentSearch studentSearch);
}
