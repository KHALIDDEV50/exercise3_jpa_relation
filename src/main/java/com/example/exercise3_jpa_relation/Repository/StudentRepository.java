package com.example.exercise3_jpa_relation.Repository;

import com.example.exercise3_jpa_relation.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
}