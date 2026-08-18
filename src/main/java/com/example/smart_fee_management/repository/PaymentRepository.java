package com.example.smart_fee_management.repository;

import com.example.smart_fee_management.model.Payment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PaymentRepository extends MongoRepository<Payment, String> {
}
