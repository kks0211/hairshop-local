package com.example.hairshop.service;

import com.example.hairshop.domain.BizMemberVO;
import com.example.hairshop.mapper.BizMemberMapper;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Map;

@Service
@AllArgsConstructor
public class BizMemberService {

    private BizMemberMapper bizMemberMapper;

    private PasswordEncoder passwordEncoder;

    public int joinUser(BizMemberVO vo) {

        String userpw = passwordEncoder.encode(vo.getPassword());
        vo.setPassword(userpw);

        int result = bizMemberMapper.joinUser(vo);

        //return memberMapper.joinUserAuth(vo.getUserid(), "ROLE_ADMIN");
        return result;
    }

}
