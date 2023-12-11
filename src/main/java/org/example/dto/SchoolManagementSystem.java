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

    /**
     *method that adds a department
     * @param departmentName defines the name of the department
     */
    public void addDepartment(String departmentName) {
        if (departmentCount < departments.length) {
            departments[departmentCount++] = new Department(departmentName);
        }else{
            System.out.println("Maximum number of departments reached.");
        }
    }

    /**
     * method that adds a student with different characteristics
     * @param fName the students first name
     * @param lName the student's last name
     * @param departmentId the Id of the student's department
     */
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

    /**
     * method that adds a teacher with different characteristics
     * @param fName the teacher's first name
     * @param lName the teacher's last name
     * @param departmentId the teacher's department Id
     */
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

    /**
     * method that adds a course with different characteristics
     * @param courseName the course's name
     * @param credits the number of credits
     * @param departmentId the course's department Id
     */
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

    /**
     * method that finds a department by its Id
     * @param departmentId the department's Id
     * @return the department or null
     */
    public Department findDepartment(String departmentId) {
        for (Department department : departments) {
            if (department != null && department.getId().equals(departmentId)) {
                return department;
            }
        }
        return null;
    }

    /**
     * Method that finds a student by its Id
     * @param studentId the student's Id
     * @return The student or null
     */
    public Student findStudent(String studentId) {
        for (Student student : students) {
            if (student != null && student.getId().equals(studentId)) {
                return student;
            }
        }
        return null;
    }

    /**
     * method that finds a teacher by its Id
     * @param teacherId the teacher's Id
     * @return the teacher or null
     */
    public Teacher findTeacher(String teacherId) {
        for (Teacher teacher : teachers) {
            if (teacher != null && teacher.getId().equals(teacherId)) {
                return teacher;
            }
        }
        return null;
    }

    /**
     * method that finds a course
     * @param courseId the course's Id
     * @return the course or null
     */
    public Course findCourse(String courseId) {
        for (Course course : courses) {
            if (course != null && course.getId().equals(courseId)) {
                return course;
            }
        }
        return null;
    }

    /**
     * method that allows for all departments to be displayed
     */
    public void displayDepartments(){
        System.out.println("All departments: ");
        for (Department department : departments) {
            if (department != null) {
                System.out.println(department);
            }
        }
    }

    /**
     * method that allows for all teachers to be displayed
     */
    public void displayTeachers(){
        System.out.println("All teachers: ");
        for (Teacher teacher : teachers) {
            if (teacher != null) {
                System.out.println(teacher);
            }
        }
    }

    /**
     * method that allows for all students to be displayed
     */
    public void displayStudents(){
        System.out.println("All students: ");
        for (Student student : students) {
            if (student != null) {
                System.out.println(student);
            }
        }
    }

    /**
     * method that allows for all courses to be displayed
     */
    public void displayCourses(){
        System.out.println("All courses: ");
        for (Course course : courses) {
            if (course != null) {
                System.out.println(course);
            }
        }
    }

    /**
     * method that allows to register a course for a student
     * @param studentId the student's Id
     * @param courseId the course's Id
     */
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

    /**
     * method that allows for a teacher to be assigned to a course
     * @param teacherId the teacher's Id
     * @param courseId the course's Id
     */
    public void assignTeacherToCourse(String teacherId, String courseId) {
        Teacher teacher = findTeacher(teacherId);
        Course course = findCourse(courseId);

        if (teacher == null) {
            System.out.println("Cannot find any teacher match with teacherId " + teacherId + ", assign teacher for course " + courseId + " failed.");
            return;
        }

        if (course == null) {
            System.out.println("Cannot find any course match with courseId " + courseId + ", assign teacher for course " + courseId + " failed.");
            return;
        }

        course.setTeacher(teacher);
        System.out.println("Course{id='" + course.getId() + "', courseName='" + course.getCourseName() + "', ...} teacher info updated successfully.");
    }
}
