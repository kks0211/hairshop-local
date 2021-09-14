package com.example.hairshop.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BizMemberVO {

    private String bizemail;
    private String bizpw;
    private String bizname;
    private String biztel;
    private String auth;

    private List<AuthVO> authList;

}
