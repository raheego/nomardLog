package bbs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import bbs.dto.BbsDTO;
import bbs.service.BbsService;
//import bbs.service.BbsService;
//import bbs.service.BbsServiceImpl;

@Controller
public class BbsController { 
	
	@Autowired
	private BbsService bbsService; // 
	
	@RequestMapping("/bbs/openBbsList.do")
//	@GetMapping("/") // 
//	public String openBoardList(Model model)  { //
		
	public ModelAndView openBbsList() throws Exception{
		ModelAndView mv = new ModelAndView("/bbs/bbsList");
		
		List<BbsDTO> list = bbsService.selectBbsList();
		mv.addObject("list", list);
		
		return mv;
	}
	
	@RequestMapping("/bbs/openBbsWrite.do")
	public String openBbsWrite() throws Exception {
		return "bbs/bbsWrite";
	}
	
	@RequestMapping("/bbs/insertBbs.do")
	public String insertBbs(BbsDTO bbs) throws Exception {
		bbsService.insertBbs(bbs);
		
		return "redirect:/bbs/openBbsList.do";
	
	}
}
	