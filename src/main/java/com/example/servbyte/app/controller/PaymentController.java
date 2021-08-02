package com.example.servbyte.app.controller;

import com.example.servbyte.app.dto.PaymentDto;
import com.example.servbyte.app.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping
    public String makePayment(@RequestBody PaymentDto paymentDto){
        return paymentService.makePayment(paymentDto);
    }
}
