package com.encore.bbs.board.controller;

import com.encore.bbs.board.dto.BbsDTO;
import com.encore.bbs.board.service.BbsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/")
public class BbsController {

    @Autowired
    private BbsService bbsService;

    @GetMapping("/") //메인 페이지 불러오기
    public String showMain(Model model) {
        BbsDTO bbsDTO = bbsService.getText(); // 빈객체 생성일뿐 데이터 가져오지 못함
        model.addAttribute("getTitle", bbsDTO.getTitle());
        model.addAttribute("getText", bbsDTO.getContents());
        return "mainpage";
    }

//    @GetMapping("/a")
//    public String showText(Model model) {
//        List<BbsDTO> bbsDTO = bbsService.getText();
//        model.addAttribute("getText", bbsDTO);
//        return "/{bbsId}";
//    }
    @GetMapping("/bbsList.html") // 해당 게시글로 이동
    public String getDetailBbs(@RequestParam(name = "bbsId") String bbsId, Model model) {
        model.addAttribute("bbsId", bbsId);
        return "/{bbsId}";
    }
    @GetMapping("/list") // 전체 리스트
    public String getAllList(Model model) {
        List<BbsDTO> list = bbsService.getBbsAllList();
        model.addAttribute("list", list);
        return "index";
    }


    @GetMapping("/{bbsId}") // 상세 게시글
    public String getDetail(@PathVariable("bbsId") int bbsId, Model model) {
        BbsDTO bbsDTO = bbsService.selectBbsDetail(bbsId);
        model.addAttribute("bbsDTO", bbsDTO);
        return "bbsList";
    }

    @GetMapping("/write") // 신규 게시글 양식 불러오기
    public String newForm(Model model) {
        model.addAttribute("bbsDto", new BbsDTO());
        return "new_form";
    }
    @PostMapping("/write") // 신규 게시글 저장 로직
    public String insertBbs(BbsDTO bbsDTO) {
        bbsService.insertBbs(bbsDTO);
        return "redirect:/list";
    }
//    @PostMapping("/write")
//    public

//    @GetMapping("/list") // 전체불러오기
//    public String showBbsList(Model model) throws Exception{
//        List<BbsDTO> bbsList = bbsService.selectBbsDetail();
//        model.addAttribute("bbsList", bbsList);
//        return "bbsList";
//}
//    @RequestMapping("openBbsList.do")
//    public ModelAndView openBbsList() throws Exception {
//        ModelAndView mv = new ModelAndView("bbsList"); // html 경로
//
//        List<BbsDTO> list = bbsService.selectBbsList();
//        mv.addObject("list", list);
//
//        return mv;
//    }
//
//    @RequestMapping("/bbs/openBbsWrite.do")
//    public String openBbsWrite() throws Exception {
//        return "bbs/bbsWrite";
//    }
//
//    @RequestMapping("/bbs/insertBbs.do")
//    public String insertBbs(BbsDTO bbs) throws Exception {
//        bbsService.insertBbs(bbs);
//
//        return "redirect:/bbs/openBbsList.do";
//    }
}
