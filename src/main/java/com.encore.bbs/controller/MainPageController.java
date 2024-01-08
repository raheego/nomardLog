package com.encore.bbs.controller;

import com.encore.bbs.dto.BbsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.encore.bbs.service.BbsService;

@Controller
public class MainPageController {
    @Autowired
    private BbsService bbsService;

    @GetMapping("/") //메인 페이지 불러오기
    public String showMain(Model model) throws Exception {
        BbsDTO bbsDTO = bbsService.getText(); // 빈객체 생성일뿐 데이터 가져오지 못함
        model.addAttribute("getTitle", bbsDTO.getTitle());
        model.addAttribute("getText", bbsDTO.getContents());
        return "mainpage";
    }
}
