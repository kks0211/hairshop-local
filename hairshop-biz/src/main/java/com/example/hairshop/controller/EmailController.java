package com.example.hairshop.controller;

import com.example.hairshop.service.MailSendService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@AllArgsConstructor
public class EmailController {

    private MailSendService mailSendService;

    @PostMapping("/login/email")
    public String emailCheck(String email) throws MessagingException {
        System.out.println("=== email ===> " + email);
        //HttpSession session = request.getSession();
        //mailSendService.mailSend(session, email);
        mailSendService.mailSend(email);
        return "/login/joinUser";
    }

    @PostMapping("/login/emailCert")
    @ResponseBody
    public boolean emailCertificate(String email, String cf_no) {
        boolean result = mailSendService.emailCertification(email, Integer.parseInt(cf_no));
        return result;
    }

}
