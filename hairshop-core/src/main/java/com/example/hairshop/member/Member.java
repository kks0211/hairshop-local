package com.example.hairshop.member;

import com.example.hairshop.common.BaseTimeEntity;
import com.example.hairshop.common.enums.Gender;
import lombok.NoArgsConstructor;

/*
    회원 정보(구직자)
 */
@NoArgsConstructor
public class Member extends BaseTimeEntity {

    private Long id;
    private String email; // 이메일
    private String password; // 비밀번호
    private String hopeArea; // 희망근무지역

    private String name; // 이름
    private String phone; // 연락처
    private Gender gender; // 성별
    private String birthDay; // 생년월일
    private String lastEducation; // 최종학력
    private String lastEducationName; // 학교이름
    private int hopeSalary; // 희망연봉

    private boolean verifiedEmail; // 이메일 인증여부
    private boolean showProfile; // 프로필 노출여부
    private boolean receiveEmail; // 메일 수신여부
    private boolean receiveSms; // SMS 수신여부

}
