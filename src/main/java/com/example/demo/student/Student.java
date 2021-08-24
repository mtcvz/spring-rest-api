package com.example.demo.student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Min;
import javax.validation.constraints.Max;

@Data
@NoArgsConstructor
@AllArgsConstructor
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



}