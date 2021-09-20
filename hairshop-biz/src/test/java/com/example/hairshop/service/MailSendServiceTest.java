package com.example.hairshop.service;

import com.example.hairshop.domain.BizMemberVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MailSendServiceTest {

    @Autowired
    private MailSendService mailSendService;

    @Test
    public void test() {
        String email = "kskim@sinsabridge.com";

        BizMemberVO vo = mailSendService.findEmail(email);

        if (vo.getEmail().equals(email)) {
            System.out.println(vo);
        }

    }

}