package com.example.smart_fee_management.service;

import com.example.smart_fee_management.model.Payment;
import com.example.smart_fee_management.repository.PaymentRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public Payment addPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    public void deletePayment(String id) {
        paymentRepository.deleteById(id);
    }
}
