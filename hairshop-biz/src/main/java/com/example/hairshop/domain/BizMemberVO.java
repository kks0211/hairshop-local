package com.example.hairshop.domain;

import com.example.hairshop.common.BaseTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BizMemberVO extends BaseTimeEntity {

    @NotBlank(message = "이메일은 필수 입력 값입니다.")
    private String email;
    @NotBlank(message = "비밀번호는 필수 입력 값입니다.")
    @Pattern(regexp="(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,20}",
            message = "비밀번호는 영문 대,소문자와 숫자, 특수기호가 적어도 1개 이상씩 포함된 8자 ~ 20자의 비밀번호여야 합니다.")
    private String password;
    @NotBlank(message = "담당자 이름은 필수 입력 값입니다.")
    private String name;
    @NotBlank(message = "담당자 연락처는 필수 입력 값입니다.")
    private String tel;
    private String auth;
    private String emailYn;

    private List<AuthVO> authList;




}
