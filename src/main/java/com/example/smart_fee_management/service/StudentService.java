package com.example.smart_fee_management.service;

import com.example.smart_fee_management.model.Payment;
import com.example.smart_fee_management.model.Student;
import com.example.smart_fee_management.repository.StudentRepository;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student addStudent(Student student) {

        student.setPaidFee(0);
        student.setPendingFee(student.getTotalFee());
        student.setPaymentStatus("Pending");

        if (student.getPayments() == null) {
            student.setPayments(new ArrayList<>());
        }

        return studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(String id) {

        Optional<Student> student = studentRepository.findById(id);

        if (student.isPresent()) {
            return student.get();
        }

        return null;
    }

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student updateStudent(String id, Student student) {

        Optional<Student> existingStudent = studentRepository.findById(id);

        if (existingStudent.isPresent()) {

            Student updatedStudent = existingStudent.get();

            updatedStudent.setStudentId(
                    student.getStudentId());

            updatedStudent.setName(
                    student.getName());

            updatedStudent.setUsn(
                    student.getUsn());

            updatedStudent.setEmail(
                    student.getEmail());

            updatedStudent.setPhone(
                    student.getPhone());

            updatedStudent.setCourse(
                    student.getCourse());

            updatedStudent.setSemester(
                    student.getSemester());

            updatedStudent.setTotalFee(
                    student.getTotalFee());

            return studentRepository.save(updatedStudent);
        }

        return null;
    }

    public boolean deleteStudent(String id) {

        Optional<Student> student = studentRepository.findById(id);

        if (student.isPresent()) {

            studentRepository.deleteById(id);

            return true;
        }

        return false;
    }

    public Student recordPayment(
            String id,
            Double amount) {

        Student student = getStudentById(id);

        if (student == null) {
            return null;
        }

        if (amount == null || amount <= 0) {
            return null;
        }

        double paidFee = student.getPaidFee();

        double totalFee = student.getTotalFee();

        double pendingFee = totalFee - paidFee;

        if (amount > pendingFee) {
            return null;
        }

        paidFee += amount;

        pendingFee = totalFee - paidFee;

        student.setPaidFee(paidFee);

        student.setPendingFee(pendingFee);

        if (paidFee >= totalFee) {
            student.setPaymentStatus("Paid");
        } else if (paidFee > 0) {
            student.setPaymentStatus("Partially Paid");
        } else {
            student.setPaymentStatus("Pending");
        }

        if (student.getPayments() == null) {
            student.setPayments(new ArrayList<>());
        }

        Payment payment = new Payment(
                amount,
                LocalDateTime.now());

        student.getPayments().add(payment);

        return studentRepository.save(student);
    }
}
