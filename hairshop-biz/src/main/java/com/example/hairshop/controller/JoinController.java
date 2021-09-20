package com.example.hairshop.controller;

import com.example.hairshop.domain.BizMemberVO;
import com.example.hairshop.service.BizMemberService;
import com.example.hairshop.util.ValidHandler;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Map;


@Controller
@RequiredArgsConstructor
public class JoinController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final BizMemberService bizMemberService;

    @GetMapping("/joinUser")
    public String joinUserGet(BizMemberVO vo, Model model) {
        model.addAttribute("member", vo);
        return "/join/joinUser";
    }

    @PostMapping("/joinUser")
    public String joinUserPost(@Valid BizMemberVO vo, Errors errors, Model model) {
        if (errors.hasErrors()) {
            log.info("join vo : {}", vo);
            model.addAttribute("member", vo);

            Map<String, String> validator = ValidHandler.validateHandling(errors);
            for (String key : validator.keySet()) {
                model.addAttribute(key, validator.get(key));
            }
            return "/join/joinUser";

        }

        bizMemberService.joinUser(vo);
        return "/login/login";
    }

}
