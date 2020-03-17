package com.soft1851.spring.ioc.entity;

import java.util.List;

/**
 * @author dyf
 */
public class Student {
    private Integer id;
    private String name;
    private List<String> hobbies;
    private List<Phone> phone;

    public Student(Integer id, String name, List<String> hobbies, List<Phone> phone) {
        this.id = id;
        this.name = name;
        this.hobbies = hobbies;
        this.phone = phone;
    }

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", hobbies=" + hobbies +
                ", phone=" + phone +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public List<Phone> getPhone() {
        return phone;
    }

    public void setPhone(List<Phone> phone) {
        this.phone = phone;
    }
}
