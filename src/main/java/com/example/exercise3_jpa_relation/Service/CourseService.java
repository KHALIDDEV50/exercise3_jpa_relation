package com.example.exercise3_jpa_relation.Service;

import com.example.exercise3_jpa_relation.API.ApiException;
import com.example.exercise3_jpa_relation.DTO.CourseDTO;
import com.example.exercise3_jpa_relation.Model.Course;
import com.example.exercise3_jpa_relation.Model.Student;
import com.example.exercise3_jpa_relation.Model.Teacher;
import com.example.exercise3_jpa_relation.Repository.CourseRepository;
import com.example.exercise3_jpa_relation.Repository.StudentRepository;
import com.example.exercise3_jpa_relation.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;
    private final StudentRepository studentRepository;

    // Get all Course
    public List<Course> getAllCourse() {

        return courseRepository.findAll();
    }

    // Add Course
    public void addCourse(CourseDTO courseDTO) {

        Teacher teacher = teacherRepository.findById(courseDTO.getTeacherId()).orElse(null);

        if (teacher == null) {
            throw new ApiException("Teacher not found");
        }

        Course course = new Course();

        course.setName(courseDTO.getName());

        // Connect Course with Teacher
        course.setTeacher(teacher);

        courseRepository.save(course);
    }

    // Update Course
    public void updateCourse(Integer id, CourseDTO courseDTO) {

        Course oldCourse = courseRepository.findById(id).orElse(null);

        if (oldCourse == null) {
            throw new ApiException("Course not found");
        }

        Teacher teacher = teacherRepository.findById(courseDTO.getTeacherId()).orElse(null);

        if (teacher == null) {
            throw new ApiException("Teacher not found");
        }

        oldCourse.setName(courseDTO.getName());

        // Update Teacher
        oldCourse.setTeacher(teacher);

        courseRepository.save(oldCourse);
    }

    // Delete Course
    public void deleteCourse(Integer id) {

        Course course = courseRepository.findById(id).orElse(null);

        if (course == null) {
            throw new ApiException("Course not found");
        }

        courseRepository.delete(course);
    }

    // Get Teacher Name By Course ID
    public String getTeacherNameByCourseId(Integer courseId) {

        Course course = courseRepository.findById(courseId).orElse(null);

        if (course == null) {
            throw new ApiException("Course not found");
        }

        if (course.getTeacher() == null) {
            throw new ApiException("Teacher not found");
        }

        return course.getTeacher().getName();
    }

    // Add Student To Course
    public void addStudentToCourse(Integer courseId, Integer studentId) {

        Course course = courseRepository.findById(courseId).orElse(null);

        if (course == null) {
            throw new ApiException("Course not found");
        }

        Student student = studentRepository.findById(studentId).orElse(null);

        if (student == null) {
            throw new ApiException("Student not found");
        }

        // Connect Student with Course
        course.getStudents().add(student);

        courseRepository.save(course);
    }

    // Get Students By Course ID
    public List<Student> getStudentsByCourseId(Integer courseId) {

        Course course = courseRepository.findById(courseId).orElse(null);

        if (course == null) {
            throw new ApiException("Course not found");
        }

        return course.getStudents();
    }
}