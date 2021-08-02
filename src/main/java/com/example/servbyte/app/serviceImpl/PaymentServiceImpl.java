package com.example.servbyte.app.serviceImpl;

import com.example.servbyte.app.dto.PaymentDto;
import com.example.servbyte.app.dto.PaymentResponseDto;
import com.example.servbyte.app.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Slf4j
@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    WebClient.Builder webclient;


    @Value( "${app.secret}" )
    private String secret;

    @Override
    public String makePayment(PaymentDto paymentDto) {

        var b = secret;
        PaymentResponseDto request = webclient.build()
                .post()
                .uri("https://api.paystack.co/transaction/initialize")
                .header("Authorization", "Bearer "+secret)
                .bodyValue(paymentDto)
                .retrieve()
                .bodyToMono(PaymentResponseDto.class).block();


        if(!request.getStatus()) return "failed";

        sendConfirmationEmailToCustomer();

        return "payment successful";
    }

    private void sendConfirmationEmailToCustomer() {
        log.info("Dear Customer, your order was successful. Thank you for your patronage");
    }
}
