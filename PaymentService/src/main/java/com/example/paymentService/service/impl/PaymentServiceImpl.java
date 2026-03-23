package com.example.paymentService.service.impl;

import com.example.paymentService.model.Payment;
import com.example.paymentService.repository.PaymentRepo;
import com.example.paymentService.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepo paymentRepo;

    @Override
    public Payment processPayment(Payment payment){
        return paymentRepo.save(payment);
    }

    @Override
    public Optional<Payment> getPaymentById(Long id){
        return paymentRepo.findById(id);
    }


}
