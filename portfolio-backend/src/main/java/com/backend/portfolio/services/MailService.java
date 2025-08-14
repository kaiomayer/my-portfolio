package com.backend.portfolio.services;

import com.backend.portfolio.dtos.MailDTO;
import com.backend.portfolio.utils.MailUtils;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
public class MailService {
    private JavaMailSender mailSender;
    private final String userEmail = System.getenv("EMAIL");

    public MailService(JavaMailSender mailSender){
        this.mailSender = mailSender;
    }

    public void sendSimpleMail(MailDTO mail){
        SimpleMailMessage email = new SimpleMailMessage();
        email.setFrom(userEmail);
        email.setTo(userEmail);
        email.setSubject(mail.subject());
        String body = MailUtils.formatBody(mail);
        email.setText(body);
        this.mailSender.send(email);
    }
}
