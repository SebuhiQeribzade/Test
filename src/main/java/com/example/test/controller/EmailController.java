package com.example.test.controller;

import com.example.test.dto.request.EmailSendRequestDto;
import com.example.test.service.EmailService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mail")
public class EmailController {
    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }
    @PostMapping("/send/simple")
    public void sendMail(@RequestBody EmailSendRequestDto dto){
        emailService.sendSimpleMail(dto);
    }
}
