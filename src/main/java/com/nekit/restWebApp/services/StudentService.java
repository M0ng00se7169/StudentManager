package com.nekit.restWebApp.services;

import com.nekit.restWebApp.exceptions.StudentNotFoundException;
import com.nekit.restWebApp.models.Student;
import com.nekit.restWebApp.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student addStudent(Student newStudent) {
        newStudent.setEmployeeCode(UUID.randomUUID().toString());
        return studentRepository.save(newStudent);
    }

    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }

    public Student findStudentById(Long id) {
        return studentRepository.findStudentById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student by id " + id + " was not found"));
    }

    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteStudentById(id);
    }
}
