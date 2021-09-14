package com.example.hairshop.member;

import com.example.hairshop.common.BaseTimeEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/*
    경력
 */
@NoArgsConstructor
@Getter
public class Career extends BaseTimeEntity {

    private Long id;
    private String companyName; // 근무지 이름
    private LocalDateTime startAt; // 근무 시작일
    private LocalDateTime endAt; // 근무 종료일
    private String task; // 주요업무
    private int displayOrder; // 순서

}
