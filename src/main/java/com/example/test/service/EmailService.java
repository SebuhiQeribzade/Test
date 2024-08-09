package com.example.test.service;

import com.example.test.dto.request.EmailSendRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmailService {
    private final JavaMailSender javaMailSender;
    public void sendSimpleMail(EmailSendRequestDto dto){
        SimpleMailMessage message=new SimpleMailMessage();

        message.setTo(dto.getTo());
        message.setFrom(dto.getFrom());
        message.setSubject(dto.getSubject());
        message.setText(dto.getText());

        javaMailSender.send(message);

//        void sendEmail() {
//            SimpleMailMessage msg = new SimpleMailMessage();
//            msg.setTo("s.axmed14@mail.com");
//            msg.setFrom("s.axmedov99@gmail.com");
//            msg.setSubject("Testing from Spring Boot");
//            msg.setText("Hello World \n Spring Boot Email");
//            javaMailSender.send(msg);
//        }
    }
}
