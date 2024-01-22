package com.zair.controllers;

import com.zair.entities.User;
import com.zair.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllConnected() {
        return ResponseEntity.status(HttpStatus.OK).body(service.findAllConnected());
    }

    @MessageMapping("/user.save")
    @SendTo("/user/public")
    public User save(@Payload User user) {
        service.save(user);
        return user;
    }

    @MessageMapping("/user.disconnect")
    @SendTo("/user/public")
    public User disconnect(@Payload User user) {
        service.disconnect(user);
        return user;
    }
}
