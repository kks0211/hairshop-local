package com.example.hairshop.controller;

import com.example.hairshop.domain.BizMemberVO;
import com.example.hairshop.service.MailSendService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@AllArgsConstructor
public class EmailController {

    private MailSendService mailSendService;

    // 이메일 인증 요청
    @PostMapping("/login/email")
    public String emailCheck(String email, BizMemberVO vo, Model model) throws Exception {

        BizMemberVO emailCheck = mailSendService.findEmail(email);

        if (emailCheck != null) {
            throw new Exception("이미 등록된 이메일입니다.");
        } else {

            mailSendService.mailSend(email);
            model.addAttribute("member", vo);
        }
        return "/join/joinUser";
    }

    // 이메일 검증
    @PostMapping("/login/emailCert")
    @ResponseBody
    public boolean emailCertificate(String email, String cf_no) {
        boolean result = mailSendService.emailCertification(email, Integer.parseInt(cf_no));
        return result;
    }

}
