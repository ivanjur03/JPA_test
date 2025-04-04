package com.example.JPA_test.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Entity
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    public Integer id;

    @Column(name="name")
    public String name;
    @Column(name="email")
    public String email;
    @Column(name="age")
    public Integer age;
    @Column(name="birthday")
    public Date birthday;

}
