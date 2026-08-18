package com.example.smart_fee_management.model;

import java.time.LocalDateTime;

public class Payment {

    private double amount;
    private LocalDateTime paymentDate;

    public Payment() {
    }

    public Payment(double amount, LocalDateTime paymentDate) {
        this.amount = amount;
        this.paymentDate = paymentDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDateTime paymentDate) {
        this.paymentDate = paymentDate;
    }
}
