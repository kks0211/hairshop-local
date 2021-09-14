package com.example.hairshop.member;

import com.example.hairshop.common.BaseTimeEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/*
    교육 정보
 */
@NoArgsConstructor
@Getter
public class Education extends BaseTimeEntity {

    private Long id;
    private String name; // 교육기관 이름
    private LocalDateTime startAt; // 교육 시작일
    private LocalDateTime endAt; // 교육 종료일

}
