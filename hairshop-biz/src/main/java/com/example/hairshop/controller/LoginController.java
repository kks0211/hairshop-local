package com.example.hairshop.controller;

import com.example.hairshop.domain.BizMemberVO;
import com.example.hairshop.service.BizMemberService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class LoginController {

    private BizMemberService bizMemberService;

    @GetMapping("/joinUser")
    public String joinUserGet(){

        return "/login/joinUser";
    }

    @PostMapping("/joinUser")
    public String joinUserPost(BizMemberVO vo){
        bizMemberService.joinUser(vo);
        return "/login/login";
    }

    @GetMapping("/login")
    public String loginGet(){
        return "/login/login";
    }

}
