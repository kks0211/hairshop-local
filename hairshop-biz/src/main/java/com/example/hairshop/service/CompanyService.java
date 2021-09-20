package com.example.hairshop.service;

import com.example.hairshop.domain.CompanyVO;
import com.example.hairshop.mapper.CompanyMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CompanyService {

    private CompanyMapper companyMapper;

    public int write(CompanyVO vo) {

        int result = companyMapper.write(vo);

        return result;
    }

}
