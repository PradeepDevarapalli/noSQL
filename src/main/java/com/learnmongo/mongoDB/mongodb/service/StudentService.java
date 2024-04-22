package com.learnmongo.mongoDB.mongodb.service;

import com.learnmongo.mongoDB.mongodb.documents.Student;
import com.learnmongo.mongoDB.mongodb.exceptions.StudentNotFound;
import com.learnmongo.mongoDB.mongodb.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public void deleteAllStudents() {
         studentRepository.deleteAll();
         //return "Deleted all student data";
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public ResponseEntity<Object> deleteStudentById(String id) {
        Optional<Student> student = Optional.empty();
        if(id != null) {
            if(studentRepository.findById(id).isPresent()) {
                System.out.println("---->" +id);
                studentRepository.deleteById(id);

            }
            else
                throw new StudentNotFound();
        }
        return ResponseEntity.status(HttpStatus.OK).body("Deleted");
    }

    public void deletebyID(String id) {
         studentRepository.deleteById(id);
    }
}
