package com.example.demo.student;

import javax.persistence.*;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Min;
import javax.validation.constraints.Max;

@Entity
@Table(name = "studentsdatabase")
public class Student {

    @Id
    private String id;

    @NotNull(message = "Name cannot be null.")
    @Size(min = 2, max = 12, message = "Name must be 2-15 characters.")
    private String name;

    @Min(value = 9, message = "Grade cannot be less than 9.")
    @Max(value = 12, message = "Grade cannot be greater than 12.")
    private int grade;

    @Min(value = 0, message = "Mark cannot be less than 0.")
    @Max(value = 100, message = "Mark cannot be greater than 100.")
    private int mark;

    private String branch;

    public String getBranch(){ return branch; }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int age) {
        this.grade = age;
    }

    public int getMark(){ return mark; }

    public void setMark(int mark){ this.mark = mark; }

}