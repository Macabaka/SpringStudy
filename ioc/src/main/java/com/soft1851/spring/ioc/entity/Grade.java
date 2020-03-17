package com.soft1851.spring.ioc.entity;

import java.util.Map;

/**
 * @author dyf
 */
public class Grade {
    private String name;
    private Map<String,Student> students;

    public Grade(String name, Map<String, Student> students) {
        this.name = name;
        this.students = students;
    }

    public Grade() {
    }

    @Override
    public String toString() {
        return "Grade{" +
                "name='" + name + '\'' +
                ", students=" + students +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Student> getStudents() {
        return students;
    }

    public void setStudents(Map<String, Student> students) {
        this.students = students;
    }
}
