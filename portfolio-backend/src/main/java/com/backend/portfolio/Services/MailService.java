package com.backend.portfolio.Services;

import com.backend.portfolio.Dtos.MailDTO;
import com.backend.portfolio.Utils.MailUtils;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
public class MailService {
    private final JavaMailSender mailSender;

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
