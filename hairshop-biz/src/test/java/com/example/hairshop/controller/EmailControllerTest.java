package com.example.hairshop.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.mail.MessagingException;

@SpringBootTest
class EmailControllerTest {

    @Autowired
    private EmailController emailController;

    @Test
    void emailSend() throws MessagingException {
        emailController.emailCheck("kskim@sinsabridge.com");
    }
}