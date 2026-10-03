package com.example.exercise3_jpa_relation.Controller;

import com.example.exercise3_jpa_relation.API.ApiResponse;
import com.example.exercise3_jpa_relation.DTO.StudentDTO;
import com.example.exercise3_jpa_relation.Service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    // Get all Student
    @GetMapping("/get")
    public ResponseEntity<?> getAllStudent() {

        return ResponseEntity.status(200).body(studentService.getAllStudent());
    }

    // Get Student by ID
    @GetMapping("/get/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable Integer id) {

        return ResponseEntity.status(200).body(studentService.getStudentById(id));
    }

    // Add Student
    @PostMapping("/add")
    public ResponseEntity<?> addStudent(@RequestBody @Valid StudentDTO studentDTO) {

        studentService.addStudent(studentDTO);

        return ResponseEntity.status(200).body(new ApiResponse("Student Add Successful"));
    }

    // Update Student
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable Integer id, @RequestBody @Valid StudentDTO studentDTO) {

        studentService.updateStudent(id, studentDTO);

        return ResponseEntity.status(200).body(new ApiResponse("Student Update Successful"));
    }

    // Delete Student
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable Integer id) {

        studentService.deleteStudent(id);

        return ResponseEntity.status(200).body(new ApiResponse("Student Delete Successful"));
    }

    // Change Student Major
    @PutMapping("/major/{studentId}/{major}")
    public ResponseEntity<?> changeStudentMajor(@PathVariable Integer studentId, @PathVariable String major) {

        studentService.changeStudentMajor(studentId, major);

        return ResponseEntity.status(200).body(new ApiResponse("Student Major Update Successful"));
    }
}