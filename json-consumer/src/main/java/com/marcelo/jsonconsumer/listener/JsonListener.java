package com.marcelo.jsonconsumer.listener;

import com.marcelo.jsonconsumer.model.Payment;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import static java.lang.Thread.sleep;


@Log4j2
@Component
public class JsonListener {

    @SneakyThrows
    @KafkaListener(topics = "payment-topic", groupId = "create-group", containerFactory = "jsonContainerFactory")
    public void antiFraude(@Payload Payment payment){
        log.info("RECEBI O PAGAMENTO {}", payment.toString());
        sleep(2000);
        log.info("Validando fraude ...");
        sleep(2000);

        log.info("Compra Aprovada...");
        sleep(2000);
    }

    @SneakyThrows
    @KafkaListener(topics = "payment-topic", groupId = "pdf-group", containerFactory = "jsonContainerFactory")
    public void pdfGenerator(@Payload Payment payment){
        log.info("Gerando PDF do produto ...d, {}", payment.getId());
        sleep(3000);
    }

    @SneakyThrows
    @KafkaListener(topics = "payment-topic", groupId = "email-group", containerFactory = "jsonContainerFactory")
    public void sendEmail(){
        log.info("Enviando E-mail de Confirmação ...");
    }

}
