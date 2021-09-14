package com.example.hairshop.biz;

import com.example.hairshop.common.BaseTimeEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

/*
    회사정보
 */
@NoArgsConstructor
@Getter
public class Company extends BaseTimeEntity {

    private Long id;
    private String name; // 이름
    private String address; // 주소
    private String businessNumber; // 사업자등록번호
    private String homepage; // 회사홈페이지
    private String information; // 회사소개

}
