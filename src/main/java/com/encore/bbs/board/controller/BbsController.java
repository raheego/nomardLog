package com.encore.bbs.board.controller;

import java.util.List;

import com.encore.bbs.board.dto.CommentDTO;
import com.encore.bbs.board.dto.HashTag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.encore.bbs.board.dto.BbsDTO;
import com.encore.bbs.board.service.BbsService;

@Controller
public class BbsController { 
	
	@Autowired
	private BbsService bbsService; 
	
	@RequestMapping(value= "/bbs", method=RequestMethod.GET)  //http://localhost:8080/bbs
	public ModelAndView openBbsList() throws Exception{
		ModelAndView mv = new ModelAndView("/bbs/bbsList");
		
		List<BbsDTO> list = bbsService.selectBbsList();
		mv.addObject("list", list);
		
		return mv;
	}

	@RequestMapping(value= "/bbs/write", method=RequestMethod.GET)
	public String openBbsWrite() throws Exception {
		return "/bbs/bbsWrite";
	}

	@RequestMapping(value= "/bbs/write", method=RequestMethod.POST)
	public String insertBbs(@RequestParam String content, BbsDTO bbs, MultipartHttpServletRequest multipartHttpServletRequest) throws Exception {
		bbsService.insertBbs(bbs, multipartHttpServletRequest, content);

		return "redirect:/bbs";
	}

	@RequestMapping(value= "/bbs/{bbsId}", method=RequestMethod.GET) //@GetMapping
	public ModelAndView openBbsDetail(@PathVariable("bbsId") int bbsId) throws Exception {
		ModelAndView mv = new ModelAndView("/bbs/bbsDetail");
		BbsDTO bbs = bbsService.selectBbsDetail(bbsId);
		HashTag hashTag = bbsService.selectHashtag(bbs, bbsId); //수정해야함
		List<CommentDTO> comments = bbsService.getCommentsByBbsId(bbsId); // 댓글조회는 완료
		mv.addObject("bbs", bbs);
		mv.addObject("comments", comments);

		return mv;

	}

	@RequestMapping(value= "/bbs/{bbsId}", method=RequestMethod.PUT)  // 수정요청
	public String updateBbs(BbsDTO bbs) throws Exception {
	  bbsService.updateBbs(bbs);         //게시글 수정
	  return "redirect:/bbs";  //수정완료 후 게시판 목록으로
	}

	@RequestMapping(value= "/bbs/{bbsId}", method=RequestMethod.DELETE)  //삭제요청
	public String deleteBbs(@PathVariable("bbsId") int bbsId) throws Exception {
	  bbsService.deleteBbs(bbsId);      //게시글 삭제
	  return "redirect:/bbs";  //삭제완료 후 게시판 목록으로

	     }
    }
