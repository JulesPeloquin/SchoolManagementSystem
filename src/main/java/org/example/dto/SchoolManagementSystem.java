package org.example.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;

@Getter
@Setter
public class SchoolManagementSystem {
    private Department[] departments = new Department[5];
    private int departmentCount = 0;
    private Student[] students = new Student[200];
    private int studentCount = 0;
    private Teacher[] teachers = new Teacher[20];
    private int teacherCount = 0;
    private Course[] courses = new Course[30];
    private int courseCount = 0;

    public SchoolManagementSystem() {
    }

    public void addDepartment(String departmentName) {
        if (departmentCount < departments.length) {
            departments[departmentCount++] = new Department(departmentName);
        }else{
            System.out.println("Maximum number of departments reached.");
        }
    }

    public void addStudent(String fName, String lName, String departmentId) {
        Department department = findDepartment(departmentId);
        if (department != null && studentCount < students.length) {
            students[studentCount++] = new Student(fName, lName, department);
        }else if (department == null) {
            System.out.println("Department not found");
        }else{
            System.out.println("Maximum number of students reached.");
        }
    }
    public void addTeacher(String fName, String lName, String departmentId) {
        Department department = findDepartment(departmentId);
        if (department != null && teacherCount < teachers.length) {
            teachers[teacherCount++] = new Teacher(fName, lName, department);
        }else if (department == null) {
            System.out.println("Department not found");
        }else{
            System.out.println("Maximum number of teachers reached.");
        }
    }
    public void addCourse(String courseName, double credits, String departmentId) {
        Department department = findDepartment(departmentId);
        if (department != null && courseCount < courses.length) {
            courses[courseCount++] = new Course(courseName, credits, department);
        }else if (department == null) {
            System.out.println("Department not found");
        }else{
            System.out.println("Maximum number of courses reached.");
        }
    }

    public Department findDepartment(String departmentId) {
        for (Department department : departments) {
            if (department != null && department.getId().equals(departmentId)) {
                return department;
            }
        }
        return null;
    }
    public Student findStudent(String studentId) {
        for (Student student : students) {
            if (student != null && student.getId().equals(studentId)) {
                return student;
            }
        }
        return null;
    }
    public Teacher findTeacher(String teacherId) {
        for (Teacher teacher : teachers) {
            if (teacher != null && teacher.getId().equals(teacherId)) {
                return teacher;
            }
        }
        return null;
    }
    public Course findCourse(String courseId) {
        for (Course course : courses) {
            if (course != null && course.getId().equals(courseId)) {
                return course;
            }
        }
        return null;
    }
    public void displayDepartments(){
        System.out.println("All departments: ");
        for (Department department : departments) {
            if (department != null) {
                System.out.println(department);
            }
        }
    }
    public void displayTeachers(){
        System.out.println("All teachers: ");
        for (Teacher teacher : teachers) {
            if (teacher != null) {
                System.out.println(teacher);
            }
        }
    }
    public void displayStudents(){
        System.out.println("All students: ");
        for (Student student : students) {
            if (student != null) {
                System.out.println(student);
            }
        }
    }
    public void displayCourses(){
        System.out.println("All courses: ");
        for (Course course : courses) {
            if (course != null) {
                System.out.println(course);
            }
        }
    }
    public void registerCourseForStudent(String studentId, String courseId) {
        Student student = findStudent(studentId);
        Course course = findCourse(courseId);

        if (student == null || course == null) {
            System.out.println("Student or course not found.");
            return;
        }
        if (Arrays.asList(student.getCourses()).contains(course)){
            System.out.println("Student is already registered for this course.");
            return;
        }
        if (student.getCourseNum() >= Student.MAX_COURSES) {
            System.out.println("Student has already registered for the maximum number of courses.");
            return;
        }
        if (course.getStudentNum() >= Course.MAX_STUDENTS) {
            System.out.println("Course has reached max student capacity.");
            return;
        }
        student.addCourse(course);
        course.addStudent(student);
        System.out.println("Registration is successful : Student " + studentId + "added to course " + courseId + ".");
    }
}
