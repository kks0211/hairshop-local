package com.example.hairshop.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BizMemberVO {

    private String email;
    private String password;
    private String name;
    private String tel;
    private String auth;
    private String emailYn;

    private List<AuthVO> authList;

}
