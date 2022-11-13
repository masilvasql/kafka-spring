package com.marcelo.paymentservice.service;

import com.marcelo.paymentservice.model.Payment;

public interface PaymentService {

    void sendPayment(Payment payment);

}
