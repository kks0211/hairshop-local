package com.example.hairshop.mapper;

import com.example.hairshop.domain.BizMemberVO;

public interface BizMemberMapper {

    BizMemberVO findByEmail(String bizemail);

    int joinUser(BizMemberVO vo);

}
