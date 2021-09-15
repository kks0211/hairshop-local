package com.example.hairshop.common.enums;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

class SigunguTest {

    @Test
    void 시만_불러온다() {
        List<Sigungu> parents = Sigungu.parents();
        //System.out.println("parents = " + parents.get(0).getChildren());
        List<String> seoulGuDisplayNames = parents.get(0).getChildren()
                .stream()
                .map(gu -> gu.getDisplayName())
                .sorted()
                .collect(Collectors.toList());
        System.out.println(seoulGuDisplayNames);
    }

}
