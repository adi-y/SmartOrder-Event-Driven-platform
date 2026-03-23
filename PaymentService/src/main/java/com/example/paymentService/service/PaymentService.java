package com.example.paymentService.service;

import com.example.paymentService.model.Payment;

import java.util.Optional;

public interface PaymentService {
    Payment processPayment(Payment payment);

    Optional<Payment> getPaymentById(Long id);
}
