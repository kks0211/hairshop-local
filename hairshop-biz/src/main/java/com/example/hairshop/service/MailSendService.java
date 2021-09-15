package com.example.hairshop.service;

import com.example.hairshop.util.MailHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class MailSendService {

    private final JavaMailSenderImpl JavaMailSenderImpl;

    public void mailSend(HttpSession session, String email) throws MessagingException {
        try {
            MailHandler handler = new MailHandler(JavaMailSenderImpl);
            Random random = new Random(System.currentTimeMillis());
            long start = System.currentTimeMillis();

            int result = 100000 + random.nextInt(900000);

            handler.setTo(email);
            handler.setFrom("dev.kks0211@gmail.com");
            handler.setSubject("인증번호 발송되었습니다.");

            String mailContent = "<p>인증 번호 " + result + "</p>";
            handler.setText(mailContent, true);
            handler.send();

            long end = System.currentTimeMillis();
            session.setAttribute("" + email, result);
            System.out.println("발송 완료 : " + (end - start) / 1000.0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean emailCertification(HttpSession session, String email, int cfNumber) {
        try {
            int generationCode = (int) session.getAttribute(email);

            if (generationCode == cfNumber) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            throw e;
        }
    }

}

