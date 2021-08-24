package com.example.demo.repository;

import com.example.demo.student.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface StudentRepository extends PagingAndSortingRepository<Student,String > {

    @Query("SELECT student from Student student where student.grade = :grade")
    List<Student> findByGrades(Pageable pageable, @Param("grade") int grade);
    Iterable<Student> findAllByGrade(int grade,Sort sort);
    Iterable<Student> findAllByBranch(String branch,Sort sort);
    @Query("SELECT student from Student student where student.mark > 80 order by student.mark desc")
    List<Student> findBestStudents();
    @Query("SELECT student from Student student where (:name is null or student.name LIKE %:name%) " +
            "and (:grade = 0 or student.grade = :grade) and (:mark = 0 or student.mark = :mark) and " +
            "(:branch is null or student.branch = :branch)" )
    List<Student> findStudents(@Param("name") String name, @Param("grade") int grade, @Param("mark") int mark, @Param("branch")String branch);
}