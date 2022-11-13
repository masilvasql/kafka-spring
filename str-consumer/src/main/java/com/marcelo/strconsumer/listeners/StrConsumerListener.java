package com.marcelo.strconsumer.listeners;

import com.marcelo.strconsumer.custom.StrConsumerCustomListener;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class StrConsumerListener {

    @SneakyThrows
    @StrConsumerCustomListener(groupId = "group-1")
    public void create(String message){
       log.info("CREATE ::: Receive Message {}", message);
       throw new IllegalArgumentException("Exception...");
    }

    @StrConsumerCustomListener(groupId = "group-1")
    public void log(String message){
        log.info("LOG ::: Receive Message {}", message);
    }

    @KafkaListener(groupId = "group-2", containerFactory = "validMessageContainerFactory", topics = "str-topic")
    public void history(String message){
        log.info("HISTORY :::Receive Message {}", message);
    }

}
