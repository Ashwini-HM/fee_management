package com.example.smart_fee_management.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "students")
public class Student {

    @Id
    private String id;

    private String studentId;
    private String name;
    private String usn;
    private String email;
    private String phone;
    private String course;
    private int semester;
    private double totalFee;

    private double paidFee;
    private double pendingFee;
    private String paymentStatus;

    private List<Payment> payments = new ArrayList<>();

    public Student() {
    }

    public Student(String studentId, String name, String usn,
            String email, String phone, String course,
            int semester, double totalFee) {

        this.studentId = studentId;
        this.name = name;
        this.usn = usn;
        this.email = email;
        this.phone = phone;
        this.course = course;
        this.semester = semester;
        this.totalFee = totalFee;
        this.paidFee = 0;
        this.pendingFee = totalFee;
        this.paymentStatus = "Pending";
    }

    public String getId() {
        return id;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsn() {
        return usn;
    }

    public void setUsn(String usn) {
        this.usn = usn;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public double getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(double totalFee) {
        this.totalFee = totalFee;
        updateFeeDetails();
    }

    public double getPaidFee() {
        return paidFee;
    }

    public void setPaidFee(double paidFee) {
        this.paidFee = paidFee;
        updateFeeDetails();
    }

    public double getPendingFee() {
        return pendingFee;
    }

    public void setPendingFee(double pendingFee) {
        this.pendingFee = pendingFee;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    private void updateFeeDetails() {

        pendingFee = totalFee - paidFee;

        if (pendingFee < 0) {
            pendingFee = 0;
        }

        if (paidFee <= 0) {
            paymentStatus = "Pending";
        } else if (paidFee >= totalFee) {
            paymentStatus = "Paid";
        } else {
            paymentStatus = "Partially Paid";
        }
    }
}
