package org.example.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Course {
    private static int nextId = 1;
    private String id;
    private String courseName;
    private double credits;
    private Department department;
    private Teacher teacher;
    private Student[] students;
    private int studentNum;

    public Course(String courseName, double credits, Department department) {
        this.id = "C" + String.format("%03d", nextId++);
        this.courseName = courseName;
        this.credits = credits;
        this.department = department;
        this.students = new Student[30];
        this.studentNum = 0;
    }

    public void addStudent(Student student) {
        if (studentNum < students.length) {
            students[studentNum] = student;
            studentNum++;
        }else{
            System.out.println("Maximum number of students reached for course" + id);
        }
    }
}
