//package com.encore.bbs.mainpage;
//
//import com.encore.bbs.board.dto.BbsDTO;
//import com.encore.bbs.board.service.BbsService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class MainPageController {
//    @Autowired
//    private BbsService bbsService;
//
//    @GetMapping("/") //메인 페이지 불러오기
//    public String showMain(Model model) {
//        BbsDTO bbsDTO = bbsService.getText(); // 빈객체 생성일뿐 데이터 가져오지 못함
//        model.addAttribute("getTitle", bbsDTO.getTitle());
//        model.addAttribute("getText", bbsDTO.getContents());
//        return "mainpage";
//    }
//}
