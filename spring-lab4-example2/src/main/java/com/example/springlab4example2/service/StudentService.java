package com.example.springlab4example2.service;

import com.example.springlab4example2.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private List<Student> students = new ArrayList<>();

    public StudentService() {
        setUpInitialStudentsData();
    }

    public List<Student> getStudents() {
        return students;
    }

    public void save(Student student) {
        Optional<Student> found = students.stream().filter(s -> s.getFirstName().equals(student.getFirstName()))
                .filter(s -> s.getLastName().equals(student.getLastName()))
                .findFirst();

        if (!found.isPresent()) {
            students.add(student);
        }
    }

    public Optional<Student> getByUsername(String username) {
        return students.stream().filter(s -> s.getUsername().equals(username)).findFirst();
    }

    public void delete(String username) {
        Optional<Student> found = getByUsername(username);
        if (found.isPresent()) {
            students.remove(found.get());
        }
    }

    public void update(Student student) {
        Optional<Student> found = getByUsername(student.getUsername());
        if (found.isPresent()) {
            students.remove(found.get());
            students.add(student);
        }
    }

    private void setUpInitialStudentsData() {
        createAndSave("Ion", "Popescu");
        createAndSave("Gigel", "Ionescu");
    }

    private void createAndSave(String firstName, String lastName) {
        Student student = Student.builder()
                .firstName(firstName)
                .lastName(lastName)
                .username(firstName + lastName)
                .build();

        students.add(student);
    }
}
