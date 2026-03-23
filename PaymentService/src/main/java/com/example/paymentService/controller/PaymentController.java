package com.example.paymentService.controller;

import com.example.paymentService.model.Payment;
import com.example.paymentService.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping
    public Payment processPayment(@RequestBody Payment payment){
        return paymentService.processPayment(payment);
    }

    @GetMapping("/{id}")
    public Optional<Payment> getPayment(@PathVariable Long id){
        return paymentService.getPaymentById(id);
    }

}
