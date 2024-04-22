package com.learnmongo.mongoDB.mongodb.controller;

import com.learnmongo.mongoDB.mongodb.documents.Student;
import com.learnmongo.mongoDB.mongodb.exceptions.StudentNotFound;
import com.learnmongo.mongoDB.mongodb.service.StudentNotFoundResponse;
import com.learnmongo.mongoDB.mongodb.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student s = studentService.createStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(s);
    }

    @GetMapping("/delete")
    public ResponseEntity<String> deleteAllStudents() {
        studentService.deleteAllStudents();
        return ResponseEntity.status(HttpStatus.CREATED).body("Deleted all student data");
    }

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.status(HttpStatus.FOUND).body(studentService.getAllStudents());
    }

    @GetMapping("/deleteById/{id}")
    public ResponseEntity<Object> deleteStudentById(@PathVariable String id) {
        try {
            studentService.deleteStudentById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Deleted student with ID: " +id);
        } catch (StudentNotFound studentNotFound) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new StudentNotFoundResponse(HttpStatus.BAD_REQUEST.value(), "Student with specified ID is not found")
            );
        }
    }
    @GetMapping("/deleteBy/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable String id) {
            studentService.deletebyID(id);
            return ResponseEntity.status(HttpStatus.OK).body("Deleted student with ID: " +id);

    }

}
