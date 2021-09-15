package com.example.hairshop.service;

import com.example.hairshop.mapper.BizMemberMapper;
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

    private final BizMemberMapper bizMemberMapper;

    public void mailSend(HttpSession session, String email) throws MessagingException {
        try {
            MailHandler handler = new MailHandler(JavaMailSenderImpl);
            Random random = new Random(System.currentTimeMillis());
            long start = System.currentTimeMillis();

            int cf_no = 100000 + random.nextInt(900000);

            handler.setTo(email);
            handler.setFrom("dev.kks0211@gmail.com");
            handler.setSubject("인증번호 발송되었습니다.");

            String mailContent = "<p>인증 번호 " + cf_no + "</p>";
            handler.setText(mailContent, true);
            handler.send();

            long end = System.currentTimeMillis();
            session.setAttribute("" + email, cf_no);
            System.out.println("발송 완료 : " + (end - start) / 1000.0);

            bizMemberMapper.mailCf(email, cf_no);

        } catch (Exception e) {
            e.printStackTrace();
        }
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

    /*public boolean emailCertification(HttpSession session, String email, int cf_no) {
        try {
            int generationCode = (int) session.getAttribute(email);

            if (generationCode == cf_no) {
                bizMemberMapper.deleteCf(email);
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            throw e;
        }
    }*/


}

