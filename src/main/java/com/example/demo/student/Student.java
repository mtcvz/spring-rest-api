package com.example.demo.student;

import java.util.UUID;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Min;
import javax.validation.constraints.Max;

public class Student {
    private static int counter = 0;
    //private int student_id;


    @NotNull(message = "Name cannot be null.")
    @Size(min = 2, max = 15, message = "Name must be 2-15 characters.")
    private String name;

    @Min(value = 7, message = "Age cannot be less than 7.")
    @Max(value = 18, message = "Age cannot be greater than 18.")
    private int age;

    private UUID student_id;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
        //counter++;
        student_id = UUID.randomUUID();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public UUID getStudent_id(){
        return student_id;
    }
}