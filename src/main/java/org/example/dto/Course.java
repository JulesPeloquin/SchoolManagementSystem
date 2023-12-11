package org.example.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Course {
    public static final int MAX_STUDENTS = 30;
    private static int nextId = 1;
    private String id;
    private String courseName;
    private double credits;
    private Department department;
    private Teacher teacher;
    private Student[] students;
    private int studentNum;

    /**
     * an all arguments constructor that defines a coursed
     * @param courseName the course's name
     * @param credits the amounts of credits given in a course
     * @param department the department to which the course is assigned
     */
    public Course(String courseName, double credits, Department department) {
        this.id = "C" + String.format("%03d", nextId++);
        this.courseName = courseName;
        this.credits = credits;
        this.department = department;
        this.students = new Student[MAX_STUDENTS];
        this.studentNum = 0;
    }

    /**
     * method that adds students and checks if the maximum amount of them is attained
     * @param student the students in the course
     */
    public void addStudent(Student student) {
        if (studentNum < MAX_STUDENTS) {
            students[studentNum] = student;
            studentNum++;
        }else{
            System.out.println("Maximum number of students reached for course" + id);
        }
    }
}
