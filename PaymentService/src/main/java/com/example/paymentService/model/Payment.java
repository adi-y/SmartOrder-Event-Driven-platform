package com.example.paymentService.model;

import com.example.paymentService.PaymentStatus;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@Table(name = "payments")
@Entity
@NoArgsConstructor
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    PaymentStatus paymentStatus =PaymentStatus.PENDING;

    @CreationTimestamp
    LocalDateTime createdAt;

    Long orderId;
    Long userId;
    Double amount;
    String currency;
    String description;
    String paymentMethod;



}
