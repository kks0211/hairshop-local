package com.example.hairshop.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum LastEducation {

    MIDDLE_SCHOOL("중졸", 1),
    HIGH_SCHOOL("고졸", 2),
    COLLEGE("대학(2,3년)", 3),
    UNIVERSITY("대학(4년)", 4),
    GRADUATE_MASTER("대학원(석사)", 5),
    GRADUATE_PHD("대학원(박사)", 6);

    private final String displayName;
    private final int displayOrder;

}
