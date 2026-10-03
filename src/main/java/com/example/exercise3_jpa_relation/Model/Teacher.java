package com.example.exercise3_jpa_relation.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private Integer age;

    private String email;

    private Double salary;

    // One To One
    @OneToOne(mappedBy = "teacher", cascade = CascadeType.ALL)
    private Address address;

    // One To Many
    @OneToMany(mappedBy = "teacher")
    @JsonIgnore
    private List<Course> courses;
}