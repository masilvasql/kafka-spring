package com.marcelo.strpeoducer.services;


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Log4j2
@RequiredArgsConstructor
@Service
public class StringProducerService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message){
        log.info("send message{}", message);
        kafkaTemplate.send("str-topic", message);
//                .addCallback(
//                success-> {
//                    if(success != null){
//                        log.info("Message Sended With Succes {}", message);
//                        log.info("Partition {}", success.getRecordMetadata().partition());
//                        log.info("Offset {}", success.getRecordMetadata().offset());
//                    }
//                },
//                error -> log.error("Error to send message")
//        );
    }
}
