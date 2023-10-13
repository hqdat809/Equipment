package com.example.manageequipment.consumer;

import com.example.manageequipment.dto.NotificationDto;
import com.example.manageequipment.dto.RequestDto;
import com.example.manageequipment.model.Notification;
import com.example.manageequipment.model.Role;
import com.example.manageequipment.model.User;
import com.example.manageequipment.repository.RoleCustomRepo;
import com.example.manageequipment.repository.UserRepository;
import com.example.manageequipment.service.FCMService;
import com.example.manageequipment.service.NotificationService;
import com.example.manageequipment.service.RequestService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.firebase.messaging.FirebaseMessagingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class RabbitMQConsumer {
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private RequestService requestService;

    @Autowired
    private RoleCustomRepo roleCustomRepo;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private NotificationService notificationService;

    @Autowired
    private FCMService fcmService;

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQConsumer.class);

//    @RabbitListener(queues = {"${rabbit.queue.save_request}"})
//    public void save_request_consume(RequestDto message) throws JsonProcessingException {
//        System.out.println("Message: "+ message);
//
//        requestService.createRequestEquipment(message);
//    }
//
//    @RabbitListener(queues = {"${rabbit.queue.push_notification}"})
//    public void push_notification_consume(RequestDto message) {
//        Role role = roleCustomRepo.findByName("ADMIN").get();
//
//        List<User> listUserAdmin = userRepository.findByRole(role);
//
//        listUserAdmin.forEach(user -> {
//            NotificationDto notificationDto = new NotificationDto();
//            notificationDto.setDescription("You have new request from user!");
//            notificationDto.setUserOwnerId(user.getId());
//            notificationDto.setRead(false);
//            notificationDto.setType("REQUEST");
//            notificationDto.setCreatedAt(new Date());
//
//            notificationService.createNotification(notificationDto);
//            try {
//                fcmService.sendFCMNotification(user.getDeviceToken());
//            } catch (FirebaseMessagingException e) {
//                throw new RuntimeException(e);
//            }
//        });
//    }
}
