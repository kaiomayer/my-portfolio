package com.backend.portfolio.Configs;

import jakarta.mail.Authenticator;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import lombok.extern.slf4j.Slf4j;

import java.util.Properties;

@Configuration
@Slf4j
public class MailConfig {

    @Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

        String email = System.getenv("EMAIL");
        String password = System.getenv("APP_PASSWORD"); 

        // Check if all required environment variables are present
        if (email == null || password == null) {
            log.error("There was an error when trying to set the environment variables at MailConfig.java");
            throw new IllegalStateException("Mail sender environment variables are not fully configured!");
        }

        //Sets the SMTP server properties
        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");
        props.put("mail.smtp.port", "587");

        //Creates an authenticated session
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(email, password);
            }
        });
        session.setDebug(true);

        mailSender.setJavaMailProperties(props);
        mailSender.setSession(session);

        return mailSender;
    }
}
