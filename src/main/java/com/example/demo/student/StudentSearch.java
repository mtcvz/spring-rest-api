package com.example.demo.student;

import lombok.Data;

@Data
public class StudentSearch extends Student{
    private int minMark;
    private int maxMark;
}
