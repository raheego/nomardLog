package com.encore.bbs.board.controller;

import com.encore.bbs.board.dto.BbsDTO;
import com.encore.bbs.board.service.BbsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/")
public class BbsController {

    @Autowired
    private BbsService bbsService;

    @GetMapping("/")
    public String getAllList(Model model) {
        List<BbsDTO> list = bbsService.getBbsAllList();
        model.addAttribute("list", list);
        return "index";
    }
    @GetMapping("/{bbsId}")
    public String getDetail(@PathVariable("bbsId") int bbsId, Model model) {
        BbsDTO bbsDTO = bbsService.selectBbsDetail(bbsId);
        model.addAttribute("bbsDTO", bbsDTO);
        return "bbsList";
    }

    @GetMapping("/write")
    public String newForm(Model model) {
        model.addAttribute("bbsDto", new BbsDTO());
        return "new_form";
    }
    @PostMapping("/write")
    public String insertBbs(BbsDTO bbsDTO) {
        bbsService.insertBbs(bbsDTO);
        return "redirect:/";
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
