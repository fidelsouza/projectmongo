package com.example.projectmongo.models;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("User")
public class User {

    private String id;
    private String name;

    private Integer age;

    private String city;

    public User() {
    }

    public User(String name, Integer age, String city) {
        this.name = name;
        this.age = age;
        this.city = city;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
