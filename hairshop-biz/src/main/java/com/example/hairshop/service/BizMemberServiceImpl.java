package com.example.hairshop.service;

import com.example.hairshop.domain.BizMemberVO;
import com.example.hairshop.mapper.BizMemberMapper;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BizMemberServiceImpl implements BizMemberService {

    private BizMemberMapper bizMemberMapper;

    private PasswordEncoder passwordEncoder;

    @Override
    public int joinUser(BizMemberVO vo) {

        String userpw = passwordEncoder.encode(vo.getBizpw());
        vo.setBizpw(userpw);

        int result = bizMemberMapper.joinUser(vo);

        //return memberMapper.joinUserAuth(vo.getUserid(), "ROLE_ADMIN");
        return result;
    }
}
