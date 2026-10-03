package com.example.exercise3_jpa_relation.Controller;

import com.example.exercise3_jpa_relation.API.ApiResponse;
import com.example.exercise3_jpa_relation.DTO.TeacherDTO;
import com.example.exercise3_jpa_relation.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/teacher")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;

    // Get all Teacher
    @GetMapping("/get")
    public ResponseEntity<?> getAllTeacher() {

        return ResponseEntity.status(200).body(teacherService.getAllTeacher());
    }

    // Get Teacher by ID
    @GetMapping("/get/{id}")
    public ResponseEntity<?> getTeacherById(@PathVariable Integer id) {

        return ResponseEntity.status(200).body(teacherService.getTeacherById(id));
    }

    // Add Teacher
    @PostMapping("/add")
    public ResponseEntity<?> addTeacher(@RequestBody @Valid TeacherDTO teacherDTO) {

        teacherService.addTeacher(teacherDTO);

        return ResponseEntity.status(200).body(new ApiResponse("Teacher Add Successful"));
    }

    // Update Teacher
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateTeacher(@PathVariable Integer id, @RequestBody @Valid TeacherDTO teacherDTO) {

        teacherService.updateTeacher(id, teacherDTO);

        return ResponseEntity.status(200).body(new ApiResponse("Teacher Update Successful"));
    }

    // Delete Teacher
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTeacher(@PathVariable Integer id) {

        teacherService.deleteTeacher(id);

        return ResponseEntity.status(200).body(new ApiResponse("Teacher Delete Successful"));
    }

    // Get Teacher Details
    @GetMapping("/details/{id}")
    public ResponseEntity<?> getTeacherDetails(@PathVariable Integer id) {

        return ResponseEntity.status(200).body(teacherService.getTeacherDetails(id));
    }
}