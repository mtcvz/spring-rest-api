package com.example.demo.controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

    StudentController studentController = new StudentController();

    Controller() {
        studentController.addStudent("Ahmet", 11);
        studentController.addStudent("Mehmet", 11);
        studentController.addStudent("Ayse", 11);
        studentController.addStudent("Merve", 11);
    }
}