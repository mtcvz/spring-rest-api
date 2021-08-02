package com.example.demo.student;



import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Min;
import javax.validation.constraints.Max;

@Entity
@Table(name = "studentsDB")
public class Student {

    @Id
    private String id;

    @NotNull(message = "Name cannot be null.")
    @Size(min = 2, max = 15, message = "Name must be 2-15 characters.")
    private String name;

    @Min(value = 7, message = "Age cannot be less than 7.")
    @Max(value = 18, message = "Age cannot be greater than 18.")
    private int age;

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}