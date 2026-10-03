package com.example.exercise3_jpa_relation.Service;

import com.example.exercise3_jpa_relation.API.ApiException;
import com.example.exercise3_jpa_relation.DTO.StudentDTO;
import com.example.exercise3_jpa_relation.Model.Course;
import com.example.exercise3_jpa_relation.Model.Student;
import com.example.exercise3_jpa_relation.Repository.CourseRepository;
import com.example.exercise3_jpa_relation.Repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    // Get all Student
    public List<Student> getAllStudent() {

        return studentRepository.findAll();
    }

    // Get Student by ID
    public Student getStudentById(Integer id) {

        Student student = studentRepository.findById(id).orElse(null);

        if (student == null) {
            throw new ApiException("Student not found");
        }

        return student;
    }

    // Add Student
    public void addStudent(StudentDTO studentDTO) {

        Student student = new Student();

        student.setName(studentDTO.getName());
        student.setAge(studentDTO.getAge());
        student.setMajor(studentDTO.getMajor());

        studentRepository.save(student);
    }

    // Update Student
    public void updateStudent(Integer id, StudentDTO studentDTO) {

        Student oldStudent = studentRepository.findById(id).orElse(null);

        if (oldStudent == null) {
            throw new ApiException("Student not found");
        }

        oldStudent.setName(studentDTO.getName());
        oldStudent.setAge(studentDTO.getAge());
        oldStudent.setMajor(studentDTO.getMajor());

        studentRepository.save(oldStudent);
    }

    // Delete Student
    public void deleteStudent(Integer id) {

        Student student = studentRepository.findById(id).orElse(null);

        if (student == null) {
            throw new ApiException("Student not found");
        }

        studentRepository.delete(student);
    }

    // Change Student Major
    public void changeStudentMajor(Integer studentId, String major) {

        Student student = studentRepository.findById(studentId).orElse(null);

        if (student == null) {
            throw new ApiException("Student not found");
        }

        // Get Student Courses
        List<Course> courses = student.getCourses();

        // Remove Student from all Courses
        for (Course course : courses) {

            course.getStudents().remove(student);

            courseRepository.save(course);
        }

        // Change Major
        student.setMajor(major);

        studentRepository.save(student);
    }
}