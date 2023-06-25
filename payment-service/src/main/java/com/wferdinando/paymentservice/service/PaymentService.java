package com.wferdinando.paymentservice.service;

import com.wferdinando.paymentservice.model.Payment;

public interface PaymentService {
  
    void sendPayment(Payment payment);
    
}
