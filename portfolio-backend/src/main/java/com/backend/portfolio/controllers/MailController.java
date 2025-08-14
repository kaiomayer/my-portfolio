package com.backend.portfolio.controllers;

import com.backend.portfolio.dtos.MailDTO;
import com.backend.portfolio.services.MailService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/email")
public class MailController {

    public MailService mailService;

    public MailController(MailService mailService){
        this.mailService = mailService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<HttpStatus> sendMail(@Valid @RequestBody MailDTO mailData){
        this.mailService.sendSimpleMail(mailData);
        return ResponseEntity.noContent().build();
    }

}
