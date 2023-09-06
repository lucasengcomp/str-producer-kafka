package com.br.lucasengcomp.strproducer.resources;

import com.br.lucasengcomp.strproducer.services.StringProducesServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/producer")
public class StringProducerResource {

    private final StringProducesServices producesServices;

    @PostMapping
    public ResponseEntity<?> sendMessage(@RequestBody String message) {
        producesServices.sendMessage(message);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
