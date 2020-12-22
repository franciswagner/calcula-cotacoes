package com.ricardococati.rabbitmq;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RecomendacaoSemanalCalculaSender {

    private final RabbitTemplate rabbitTemplate;

    @Getter
    @Value("${queue.diario}")
    private String diarioQueue;

    public void send(String semanal) {
      rabbitTemplate.convertAndSend(diarioQueue, semanal);
    }

}