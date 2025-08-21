package com.backend.portfolio.Controllers;

import com.backend.portfolio.Dtos.MailDTO;
import com.backend.portfolio.Services.MailService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/emails")
@AllArgsConstructor
public class MailController {
    private final MailService mailService;

    @PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<HttpStatus> sendMail(@Valid @RequestBody MailDTO mailData){
        this.mailService.sendSimpleMail(mailData);
        return ResponseEntity.noContent().build();
    }

}
