package com.encore.bbs.board.controller;

import com.encore.bbs.board.dto.BbsDTO;
import com.encore.bbs.board.service.BbsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/api")
public class BbsController {

    @Autowired
    private BbsService bbsService;

    @GetMapping("/{bbsId}")
    public String getDetail(@PathVariable("bbsId") int bbsId, Model model) {
        try {
            BbsDTO bbsDTO = bbsService.selectBbsDetail(bbsId);
//            ContinentDto continentDto = bbsService.getContinentByCountryId(bbsDTO.getCountryId());
//            CountryDto countryDto = bbsService.getCountryByCountryId(bbsDTO.getCountryId());

            model.addAttribute("bbsDTO", bbsDTO);
//            model.addAttribute("continentDto",continentDto);
//            model.addAttribute("countryDto", countryDto);

            return "bbsList";
        } catch (Exception e) {
            throw new RuntimeException("게시물 상세 정보를 조회하는 데 문제가 발생했습니다", e);
        }
//    @GetMapping("/list") // 전체불러오기
//    public String showBbsList(Model model) throws Exception{
//        List<BbsDTO> bbsList = bbsService.selectBbsDetail();
//        model.addAttribute("bbsList", bbsList);
//        return "bbsList";
    }
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
