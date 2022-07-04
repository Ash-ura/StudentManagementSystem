package com.Ashura.StudentManagementSystem.controller;

import com.Ashura.StudentManagementSystem.entity.Student;
import com.Ashura.StudentManagementSystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {

    @Autowired
    StudentService studentService;

    // list all students
    @GetMapping("/students")
    public String listStudents (Model model){
        model.addAttribute("students", studentService.getAllStudents());

        return "students";
    }

    // add a new student
    @GetMapping("/students/add")
    public String createStudentForm(Model model){

        // student object to hold new student
        Student student = new Student();

        model.addAttribute("student", student);

        return "create_student";
    }

    // save new student
    @PostMapping("/students")
    public String saveNewStudent(@ModelAttribute("student") Student student){
        studentService.saveStudent(student);
        return "redirect:/students";
    }

    // create edit student form
    @GetMapping("/students/edit/{id}")
    public String createEditStudentForm(@PathVariable Long id,  Model model){

        model.addAttribute("student", studentService.getStudentById(id));

        return "edit_student";
    }

    // edit student
    @PostMapping("/students/{id}")
    public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student student, Model model){

        // get student from DB
        Student existingStudent = studentService.getStudentById(id);
        existingStudent.setId(id);
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setCourseTitle(student.getCourseTitle());
        existingStudent.setYear(student.getYear());
        existingStudent.setResidentialStatus(student.getResidentialStatus());

        // save updated student object
        studentService.updateStudent(existingStudent);
        return "redirect:/students";
    }

    // handler method for delete student request
    @GetMapping("/students/{id}")
    public String deleteStudent(@PathVariable Long id){

        studentService.deleteStudentById(id);
        return "redirect:/students";
    }
}
