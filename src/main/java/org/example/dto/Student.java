package org.example.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Student {
    private static int nextId = 1;
    private String id;
    private String fName;
    private String lName;
    private Course[] courses;
    private int courseNum;
    private Department department;

    public Student (String fName, String lName, Department department ) {
        this.id = "S" + String.format("%03d", nextId++);
        this.fName = fName;
        this.lName = lName;
        this.department = department;
        this.courses = new Course[5];
        this.courseNum = 0;
    }

    public void addCourse(Course course) {
        if (courseNum < courses.length) {
            courses[courseNum] = course;
            courseNum++;
        }else{
            System.out.println("Maximum number of courses reached for student"+id);
        }
    }
}
