package com.example.myapplication.viewmodel.model;

/**
 * @Description:
 * @Author: ch
 * @CreateDate: 2019/7/23 15:53
 */
public class User {
    private String name;
    private String city;
    private int age;

    public User() {
    }

    public User(String name, String city, int age) {
        this.name = name;
        this.city = city;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
