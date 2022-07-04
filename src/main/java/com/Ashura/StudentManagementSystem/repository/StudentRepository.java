package com.Ashura.StudentManagementSystem.repository;

import com.Ashura.StudentManagementSystem.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
