package com.backend.portfolio.utils;

import com.backend.portfolio.dtos.MailDTO;

public class MailUtils {
    public static String formatBody(MailDTO data){
        String fullName = String.format("Name: %s\n", data.firstName() + data.lastName());
        String email = String.format("Email: %s\n", data.email());
        String phone = data.phone().isEmpty() ? "" : String.format("Phone number: %s\n", data.phone());
        String message = String.format("Message: %s\n", data.message());
        return fullName + email + phone + message;
    }
}
