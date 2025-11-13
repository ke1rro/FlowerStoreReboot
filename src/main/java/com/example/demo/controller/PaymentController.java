package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.payment.PaymentType;
import com.example.demo.service.PaymentService;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping
    public String pay(
            @RequestParam(name = "type", defaultValue = "CREDIT_CARD") PaymentType type,
            @RequestParam(name = "amount", defaultValue = "20.0") double amount) {
        return paymentService.processPayment(type, amount);
    }
}
