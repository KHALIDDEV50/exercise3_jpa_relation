package com.example.exercise3_jpa_relation.DTO;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO {

    @NotNull(message = "Teacher ID must not be null")
    @Positive(message = "Teacher ID must be positive")
    private Integer teacherId;

    @NotEmpty(message = "Area must not be empty")
    private String area;

    @NotEmpty(message = "Street must not be empty")
    private String street;

    @NotNull(message = "Building number must not be null")
    @Positive(message = "Building number must be positive")
    private Integer buildingNumber;
}