package com.encore.bbs.board.service;

import java.util.List;

import com.encore.bbs.board.dto.CommentDTO;
import com.encore.bbs.board.dto.HashTag;
import com.encore.bbs.board.dto.BbsDTO;
import org.springframework.web.multipart.MultipartHttpServletRequest;


public interface BbsService {
	
	 List<BbsDTO> selectBbsList() throws Exception ;
	 
	 void insertBbs(BbsDTO bbs, MultipartHttpServletRequest multipartHttpServletRequest, String content) throws Exception;
	 
	 BbsDTO selectBbsDetail(int bbsId) throws Exception;
	 
	 void updateBbs(BbsDTO bbs) throws Exception;
	 
	 void deleteBbs(int bbsId) throws Exception;

	int getLatestBbsId() throws Exception;

	BbsDTO getText() throws Exception;

    HashTag selectHashtag(BbsDTO bbsDTO, int bbsId) throws Exception;

	List<CommentDTO> getCommentsByBbsId(int bbsId) throws Exception;


}