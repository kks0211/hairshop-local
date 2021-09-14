package com.example.hairshop.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Gender {

    MAN("남자", 1),
    WOMAN("여자", 2),
    ETC("기타", 3);

    private final String displayName;
    private final int displayOrder;
}
