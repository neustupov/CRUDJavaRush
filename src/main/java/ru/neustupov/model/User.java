package ru.neustupov.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class User {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String name;

    @Column
    private int age;

    @Column(columnDefinition = "BOOLEAN")
    private boolean isAdmin;

    @Column(columnDefinition = "TIMESTAMP")
    private Date date;

    public User() {
    }

    public User(int id, String name, int age, boolean isAdmin, Date date) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.isAdmin = isAdmin;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean getisAdmin() {
        return isAdmin;
    }

    public void setisAdmin(boolean admin) {
        isAdmin = admin;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
