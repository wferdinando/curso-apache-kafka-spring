package com.wferdinando.jsonconsumer.listener;

import static java.lang.Thread.sleep;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.wferdinando.jsonconsumer.model.Payment;

import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
public class JsonListener {
    @SneakyThrows
    @KafkaListener(topics = "payment-topic", groupId = "create-group", containerFactory = "jsonContainerFactory")
    public void antiFraude(@Payload Payment payment){
        log.info("Recebi o pagamento {}", payment.toString());
       
        sleep(3000);
        log.info("Validando Anti-Fraude .....");
       
        sleep(4000);
        log.info("Compra aprovada! .....");
        
    }

    @SneakyThrows
    @KafkaListener(topics = "payment-topic", groupId = "pdf-group", containerFactory = "jsonContainerFactory")
    public void pdfGenerator(@Payload Payment payment){
        sleep(5000);
        log.info("Gerando PDF do Produto de id: {} .....", payment.getId());
        
    }

    @SneakyThrows
    @KafkaListener(topics = "payment-topic", groupId = "email-group", containerFactory = "jsonContainerFactory")
    public void sendEmail(){
        sleep(6000);
        log.info("Enviando E-mail de confirmação .....");
    }
}
