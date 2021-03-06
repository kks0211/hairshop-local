package com.example.hairshop.security;

import com.example.hairshop.domain.BizMemberVO;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.stream.Collectors;

@Getter
public class CustomUser extends User {

    private static final long serialVersionUID = 1L;

    private BizMemberVO bizMember;

    public CustomUser(String username, String password,
                      Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public CustomUser(BizMemberVO vo) {
        super(vo.getEmail(), vo.getPassword(), vo.getAuthList().stream()
                .map(auth -> new SimpleGrantedAuthority(auth.getAuth())).collect(Collectors.toList()));

        this.bizMember = vo;
    }
}