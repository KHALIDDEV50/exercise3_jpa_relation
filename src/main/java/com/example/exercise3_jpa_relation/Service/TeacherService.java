package com.example.exercise3_jpa_relation.Service;

import com.example.exercise3_jpa_relation.API.ApiException;
import com.example.exercise3_jpa_relation.DTO.TeacherDTO;
import com.example.exercise3_jpa_relation.Model.Teacher;
import com.example.exercise3_jpa_relation.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;

    // Get all Teacher
    public List<Teacher> getAllTeacher() {

        return teacherRepository.findAll();
    }

    // Get Teacher by ID
    public Teacher getTeacherById(Integer id) {

        Teacher teacher = teacherRepository.findById(id).orElse(null);

        if (teacher == null) {
            throw new ApiException("Teacher not found");
        }

        return teacher;
    }

    // Add Teacher
    public void addTeacher(TeacherDTO teacherDTO) {

        Teacher teacher = new Teacher();

        teacher.setName(teacherDTO.getName());
        teacher.setAge(teacherDTO.getAge());
        teacher.setEmail(teacherDTO.getEmail());
        teacher.setSalary(teacherDTO.getSalary());

        teacherRepository.save(teacher);
    }

    // Update Teacher
    public void updateTeacher(Integer id, TeacherDTO teacherDTO) {

        Teacher oldTeacher = teacherRepository.findById(id).orElse(null);

        if (oldTeacher == null) {
            throw new ApiException("Teacher not found");
        }

        oldTeacher.setName(teacherDTO.getName());
        oldTeacher.setAge(teacherDTO.getAge());
        oldTeacher.setEmail(teacherDTO.getEmail());
        oldTeacher.setSalary(teacherDTO.getSalary());

        teacherRepository.save(oldTeacher);
    }

    // Delete Teacher
    public void deleteTeacher(Integer id) {

        Teacher teacher = teacherRepository.findById(id).orElse(null);

        if (teacher == null) {
            throw new ApiException("Teacher not found");
        }

        teacherRepository.delete(teacher);
    }

    // Get Teacher Details
    public Teacher getTeacherDetails(Integer id) {

        Teacher teacher = teacherRepository.findById(id).orElse(null);

        if (teacher == null) {
            throw new ApiException("Teacher not found");
        }

        return teacher;
    }
}