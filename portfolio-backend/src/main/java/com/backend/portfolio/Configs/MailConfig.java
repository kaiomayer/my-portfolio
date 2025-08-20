package com.backend.portfolio.Configs;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class MailConfig {

    @Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

        String username = System.getenv("EMAIL");
        String password = System.getenv("APP_PASSWORD"); 

        // Check if all required environment variables are present
        if (username == null || password == null) {
            throw new IllegalStateException("Mail sender environment variables are not fully configured!");
        }

        mailSender.setUsername(username);
        mailSender.setPassword(password);

        // Set additional JavaMail properties for authentication and TLS
        //Properties props = mailSender.getJavaMailProperties();
        //props.put("mail.transport.protocol", "smtp");
        //props.put("mail.smtp.auth", "true");
        //props.put("mail.smtp.starttls.enable", "true");
        //props.put("mail.debug", "true"); // Set to "false" in production

        return mailSender;
    }
}
