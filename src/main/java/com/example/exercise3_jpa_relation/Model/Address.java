package com.example.exercise3_jpa_relation.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String area;

    private String street;

    private Integer buildingNumber;

    // One To One
    @OneToOne
    @JoinColumn
    @JsonIgnore
    private Teacher teacher;
}