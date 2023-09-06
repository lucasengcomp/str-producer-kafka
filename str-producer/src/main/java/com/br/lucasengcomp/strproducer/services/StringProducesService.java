package com.br.lucasengcomp.strproducer.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Log4j2
@RequiredArgsConstructor
@Service
public class StringProducesService {

    @Autowired
    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message) {
        kafkaTemplate.send("srt-topic", message).addCallback(
                success -> {
                    if (success != null) {
                        log.info("Send message with success {} ", message);
                        log.info("Partition {}, Offset {}",
                                success.getRecordMetadata().partition(),
                                success.getRecordMetadata().offset());
                    }
                },
                success -> log.error("Error send message {} ", message)
        );
    }
}
