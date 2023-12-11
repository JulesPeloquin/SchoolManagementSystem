package org.example.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Teacher {
    private static int nextId = 1;
    private String id;
    private String fName;
    private String lName;
    private Department department;

    /**
     * A all arguments constructor that defines a teacher
     * @param fName the teacher's first name
     * @param lName the teacher's last name
     * @param department the teacher's department
     */
    public Teacher(String fName, String lName, Department department) {
        this.id = "T" + String.format("%03d", nextId++);
        this.fName = fName;
        this.lName = lName;
        this.department = department;
    }
}
