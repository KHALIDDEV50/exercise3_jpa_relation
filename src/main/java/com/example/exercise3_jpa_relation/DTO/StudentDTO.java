package com.example.exercise3_jpa_relation.DTO;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {

    @NotEmpty(message = "Name must not be empty")
    private String name;

    @NotNull(message = "Age must not be null")
    @Positive(message = "Age must be positive")
    private Integer age;

    @NotEmpty(message = "Major must not be empty")
    private String major;
}

