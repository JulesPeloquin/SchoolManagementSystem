package org.example.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Department {
    private static int nextId = 1;
    private String id;
    private String departmentName;

    /**
     * method that gives a structure to the department
     * @param name the name of the department
     */
    public Department (String name) {
        this.id = "D" + String.format("%03d", nextId++);
        this.departmentName = name;
    }
}
