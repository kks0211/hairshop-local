package com.example.hairshop.common.enums;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
    시군구 정보
 */
@Getter
public enum Sigungu {

    SEOUL("서울", null),
        JONGRO("종로구", SEOUL),
        SEOUL_JUNGGU("중구", SEOUL),
        YONGSAN("용산구", SEOUL),
        SEONGDONG("성동구", SEOUL),
        GWANGJIN("광진구", SEOUL),
        DONGDAEMOON("동대문구", SEOUL),
        JUNGNANG("중랑구", SEOUL),
        SEONGBUK("성북구", SEOUL),
        GANGBUK("강북구", SEOUL),
        DOBONG("도봉구", SEOUL),
        NOWON("노원구", SEOUL),
        EUNPYEONG("은평구", SEOUL),
        SEODAEMUN("서대문구", SEOUL),
        MAPO("마포구", SEOUL),
        YANGCHEON("양천구", SEOUL),
        GANGSEO("강서구", SEOUL),
        GURO("구로구", SEOUL),
        GEUMCHEON("금천구", SEOUL),
        YEONGDEUNGPO("영등포구", SEOUL),
        DONGJAK("동작구", SEOUL),
        GWANAK("관악구", SEOUL),
        SEOCHO("서초구", SEOUL),
        GANGNAM("강남구", SEOUL),
        SONGPA("송파구", SEOUL),
        GANGDONG("강동구", SEOUL),
    BUSAN("부산", null),
        BUSAN_JUNGGU("중구", BUSAN),
        SEO("서구", BUSAN),
        DONG("동구", BUSAN),
        YEONGDO("영도구", BUSAN),
        BUSANJIN("부산진구", BUSAN),
        DONGRAE("동래구", BUSAN),
        NAM("남구", BUSAN),
        BUK("북구", BUSAN),
        HAEUNDAE("해운대구", BUSAN),
        SAHA("사하구", BUSAN),
        GEUMJEONG("금정구", BUSAN),
        GANSEO("강서구", BUSAN),
        YEONJE("연제구", BUSAN),
        SUYEONG("수영구", BUSAN),
        SASANG("사상구", BUSAN),
        GIJANG("기장군", BUSAN),
    DAEGU("대구", null),
    INCHEON("인천", null),
    GWANGJU("광주", null),
    DAEJEON("대전", null),
    ULSAN("울산", null),
    SEJONG("세종", null),
    GYONGGI("경기도", null),
    GANGWON("강원도", null),
    CHUNGNAM("충청남도", null),
    CHUNGBUK("충청북도", null),
    JEONNAM("전라남도", null),
    JEONBUK("전라북도", null),
    GYEONGNAM("경상남도", null),
    GYEONGBUK("경상북도", null),
    JEJU("제주", null);

    private String displayName;
    private Sigungu parent;
    private List<Sigungu> children = new ArrayList<>();

    Sigungu(String displayName, Sigungu parent) {
        this.displayName = displayName;
        this.parent = parent;
        if (this.parent != null) {
            this.parent.addChild(this);
        }
    }

    public static List<Sigungu> parents() {
        return Arrays.stream(values())
                .filter(sigungu -> sigungu.parent == null)
                .collect(Collectors.toList());
    }

    private void addChild(Sigungu child) {
        for (Sigungu c = this; c != null; c = c.parent) {
            c.children.add(child);
        }
    }

}
