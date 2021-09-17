package com.example.hairshop.service;

import com.example.hairshop.mapper.BizMemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class MailSendService {

    private final JavaMailSender javaMailSender;

    private final SpringTemplateEngine templateEngine;

    private final BizMemberMapper bizMemberMapper;

    public void mailSend(String email) throws MessagingException {
        try {

            MimeMessage message = javaMailSender.createMimeMessage();

            int cf_no = createCode();
            long start = System.currentTimeMillis();

            message.addRecipients(MimeMessage.RecipientType.TO, email);
            message.setSubject("인증 번호가 발송되었습니다.");
            message.setText(setContext(cf_no), "utf-8", "html");

            javaMailSender.send(message);

            long end = System.currentTimeMillis();
            System.out.println("발송 완료 : " + (end - start) / 1000.0);

            //bizMemberMapper.mailCf(email, cf_no);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String setContext(int cf_no) {
        Context context = new Context();
        context.setVariable("cf_no", cf_no);
        return templateEngine.process("/mailTemplate/mail", context);
    }


    public int createCode() {
        Random random = new Random(System.currentTimeMillis());
        int cf_no = 100000 + random.nextInt(900000);

        return cf_no;
    }

    public boolean emailCertification(String email, int cf_no) {
        int result = bizMemberMapper.readCf(email, cf_no);
        if (result == 1) {
            bizMemberMapper.deleteCf(email);
            return true;
        } else {
            return false;
        }

    }

}

