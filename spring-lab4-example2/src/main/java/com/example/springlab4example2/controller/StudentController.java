package com.example.springlab4example2.controller;

import com.example.springlab4example2.model.Student;
import com.example.springlab4example2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {

    private final StudentService service;

    @Autowired
    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping("/students")
    public String getAllStudents(Model model) {
        List<Student> students = service.getStudents();
        model.addAttribute("students", students);
        return "students";
    }

    @PostMapping("/create")
    public String createStudent(Student student, Model model) {
        service.save(student);
        model.addAttribute("students", service.getStudents());
        return "students";
    }

    @GetMapping("/view-create")
    public String viewCreate(Student student) {
        return "student";
    }

    @GetMapping("/delete/{username}")
    public String deleteStudent(@PathVariable String username, Model model) {
        service.delete(username);
        model.addAttribute("students", service.getStudents());
        return "students";
    }

    @GetMapping("/view-update/{username}")
    public String viewUpdate(@PathVariable String username, Model model) {
        Student student = service.getByUsername(username).get();
        model.addAttribute("student", student);
        return "update-student";
    }

    @PostMapping("/update/{username}")
    public String viewUpdate(@PathVariable String username, Student student, Model model) {
        service.update(student);
        model.addAttribute("students", service.getStudents());
        return "students";
    }
}
