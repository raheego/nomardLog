package bbs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import bbs.dto.BbsDTO;
import bbs.service.BbsService;

@Controller
public class BbsController { 
	
	@Autowired
	private BbsService bbsService; // 

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
	
