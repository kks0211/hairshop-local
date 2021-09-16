package com.example.hairshop.mapper;

import com.example.hairshop.domain.BizMemberVO;
import org.apache.ibatis.annotations.Param;

public interface BizMemberMapper {

    BizMemberVO findByEmail(String email);

    int joinUser(BizMemberVO vo);

    void mailCf(@Param("email") String email, @Param("cf_no") int cf_no);

    void deleteCf(String email);

    int readCf(@Param("email") String email, @Param("cf_no") int cf_no);

}
