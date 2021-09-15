package com.example.hairshop.biz;

import com.example.hairshop.common.BaseTimeEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.crypto.password.PasswordEncoder;

/*
    회원 정보(기업 담당자)
 */
@NoArgsConstructor
@Getter
public class BizMember extends BaseTimeEntity {

    private Long id;
    private String email; // 이메일
    @Setter
    private String password; // 비밀번호
    private String managerName; // 담당자 이름
    private String managerContact; // 담당자 연락처
    private boolean emailVerified; // 이메일 인증 여부

    public void encryptpw(PasswordEncoder encoder){
        this.password = encoder.encode(password);
    }

}
