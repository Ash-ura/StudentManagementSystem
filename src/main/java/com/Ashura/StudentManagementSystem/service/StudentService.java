package com.Ashura.StudentManagementSystem.service;

import com.Ashura.StudentManagementSystem.entity.Student;
import com.Ashura.StudentManagementSystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public Student saveStudent(Student student){
        return studentRepository.save(student);
    }

    public Student updateStudent(Student student){
        return studentRepository.save(student);
    }

    public Student getStudentById(Long id){
        return studentRepository.findById(id).get();
    }
    public void deleteStudentById(Long id){
        studentRepository.deleteById(id);
    }
}
