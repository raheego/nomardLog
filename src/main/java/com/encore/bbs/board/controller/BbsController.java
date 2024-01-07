package com.encore.bbs.board.controller;

import com.encore.bbs.board.dto.BbsDTO;
import com.encore.bbs.board.dto.HashTag;
import com.encore.bbs.board.service.BbsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class BbsController {

    @Autowired
    private BbsService bbsService;

    @GetMapping("/bbsList.html") // 해당 게시글로 이동
    public String getDetailBbs(@RequestParam(name = "bbsId") String bbsId, Model model) {
        model.addAttribute("bbsId", bbsId);
        return "/{bbsId}";
    }

    @GetMapping("/list") // 전체 리스트
    public String getAllList(Model model) {
        List<BbsDTO> list = bbsService.getBbsAllList();
        model.addAttribute("list", list);
        return "allList";
    }

    @GetMapping("/{bbsId}") // 상세 게시글
    public String getDetail(@PathVariable("bbsId") int bbsId, Model model) {
        BbsDTO bbsDTO = bbsService.selectBbsDetail(bbsId);
        model.addAttribute("bbsDTO", bbsDTO);
        return "bbsDetail";
    }

    @GetMapping("/write") // 신규 게시글 양식 불러오기
    public String newForm(Model model) {
        List<BbsDTO> countryList = bbsService.getCountryList();
        model.addAttribute("countryList", countryList);
        model.addAttribute("bbsDto", new BbsDTO());
        return "bbsWrite";
    }

    @PostMapping("/write") // 신규 게시글 저장 로직
//    public String insertBbs(@RequestParam String countryName, BbsDTO bbsDTO) {
    public String insertBbs(BbsDTO bbsDTO, HashTag hashTag) {
//        bbsService.insertCountryBbs(bbsDTO);
        bbsService.insertBbs(bbsDTO);
        bbsService.insertHashtag(hashTag);
        return "redirect:/list";
    }

//    @PostMapping("/write")
//    public String saveCountry(@RequestParam String countryName) {
//        return "redirect:/list";
//    }


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
