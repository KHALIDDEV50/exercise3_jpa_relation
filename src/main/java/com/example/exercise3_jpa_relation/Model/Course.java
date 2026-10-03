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
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    // Many To One
    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private Teacher teacher;

    // Many To Many
    @ManyToMany
    @JoinTable(name = "course_student")
    private List<Student> students;
}