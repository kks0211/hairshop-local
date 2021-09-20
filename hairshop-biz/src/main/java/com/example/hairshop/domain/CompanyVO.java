package com.example.hairshop.domain;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CompanyVO {

    private int member_no;
    @NotBlank(message = "기업이름은 필수 입력 값입니다.")
    private String name;
    @NotBlank(message = "기업주소는 필수 입력 값입니다.")
    private String address;
    @NotBlank(message = "기업 사업자번호는 필수 입력 값입니다.")
    private String irs;
    private String site;
    private String descript;

}
