package com.example.exercise3_jpa_relation.DTO;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherDTO {

    @NotEmpty(message = "Name must not be empty")
    @Size(max = 100, message = "Name must be at most 100 characters")
    private String name;

    @NotNull(message = "Age must not be null")
    @Positive(message = "Age must be positive")
    private Integer age;

    @NotEmpty(message = "Email must not be empty")
    @Email(message = "Invalid Email")
    private String email;

    @NotNull(message = "Salary must not be null")
    @Positive(message = "Salary must be positive")
    private Double salary;
}