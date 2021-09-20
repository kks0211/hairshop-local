package com.example.hairshop.controller;

import com.example.hairshop.domain.CompanyVO;
import com.example.hairshop.service.CompanyService;
import com.example.hairshop.util.ValidHandler;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@Controller
@RequiredArgsConstructor
public class CompanyController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final CompanyService companyService;

    @GetMapping("/write/company")
    public String companyGet() {
        return "/write/writeBiz";
    }

    @PostMapping("/write/company")
    public String companyWrite(CompanyVO vo, Model model, Errors errors) {

        log.info("CompanyVO vo : {}", vo);

        if (errors.hasErrors()) {
            Map<String, String> validator = ValidHandler.validateHandling(errors);
            for (String key : validator.keySet()) {
                model.addAttribute(key, validator.get(key));
            }
            return "/write/writeBiz";
        }

        companyService.write(vo);

        return "/write/writeBiz";
    }

}
