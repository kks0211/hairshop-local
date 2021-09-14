package com.example.hairshop.common;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class BaseTimeEntity {
    private LocalDateTime createdAt; // 생성시간
    private LocalDateTime updatedAt; // 마지막 업데이트시간
}
