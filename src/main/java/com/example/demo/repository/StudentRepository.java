package com.example.demo.repository;

import com.example.demo.student.Student;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface StudentRepository extends PagingAndSortingRepository<Student,String > {
    List<Student> findByGrade(int grade);
    List<Student> findByBranch(String branch);
    List<Student> findByGradeAndAndBranch(int grade,String branch);
    Iterable<Student> findAllByGrade(int grade,Sort sort);
    Iterable<Student> findAllByBranch(String branch,Sort sort);
}