package com.example.servbyte.app.service;

import com.example.servbyte.app.dto.PaymentDto;

public interface PaymentService {

    String makePayment(PaymentDto paymentDto);
}
