package org.example.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Student {
    public static final int MAX_COURSES = 5;
    private static int nextId = 1;
    private String id;
    private String fName;
    private String lName;
    private Course[] courses;
    private int courseNum;
    private Department department;

    /**
     * an all arguments contructor that defines a student
     * @param fName the student's first name
     * @param lName the student's last name
     * @param department
     */
    public Student (String fName, String lName, Department department ) {
        this.id = "S" + String.format("%03d", nextId++);
        this.fName = fName;
        this.lName = lName;
        this.department = department;
        this.courses = new Course[MAX_COURSES];
        this.courseNum = 0;
    }

    /**
     * method that adds a course for the student and makes sure it isn't a number beyond the max
     * @param course the courses the student is in
     */
    public void addCourse(Course course) {
        if (courseNum < MAX_COURSES) {
            courses[courseNum] = course;
            courseNum++;
        }else{
            System.out.println("Maximum number of courses reached for student"+id);
        }
    }
}
