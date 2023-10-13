package com.example.manageequipment.publisher;

import com.example.manageequipment.config.RabbitMQConfig;
import com.example.manageequipment.dto.RequestDto;
import com.example.manageequipment.service.RequestService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQProducer {
    @Value("${rabbit.exchange.manage_equipment}")
    private String exchange;

    @Value("${rabbit.routing.push_notification}")
    private String push_notification_routingKey;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private RequestService requestService;

    @Autowired
    private RabbitMQConfig rabbitMQConfig;

    public RabbitMQProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(RequestDto message) {
//        LOGGER.info(String.format("Message send -> %s" , message));
        requestService.createRequestEquipment(message);

//        rabbitTemplate.convertAndSend(exchange, save_request_routingKey, message );
        rabbitTemplate.convertAndSend(exchange, rabbitMQConfig.push_notification_routingKey, message);
    }
}
