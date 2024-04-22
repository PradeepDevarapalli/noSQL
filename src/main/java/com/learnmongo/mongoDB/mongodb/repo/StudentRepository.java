package com.learnmongo.mongoDB.mongodb.repo;

import com.learnmongo.mongoDB.mongodb.documents.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {

     List<Student> findByNameAndAndEmail(String name, String email);
     Optional<Student> findById(String id);
}
