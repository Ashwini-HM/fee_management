package com.example.smart_fee_management.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.smart_fee_management.model.Student;

public interface StudentRepository extends MongoRepository<Student, String> {

}
