package com.encore.bbs.board.mapper;

import java.util.List;

import com.encore.bbs.board.dto.CommentDTO;
import com.encore.bbs.board.dto.HashTag;
import org.apache.ibatis.annotations.Mapper;
import com.encore.bbs.board.dto.BbsDTO;

@Mapper
public interface BbsMapper {
	 List<BbsDTO> selectBbsList() throws Exception; 
	 
	 void insertBbs(BbsDTO bbs) throws Exception;
	
	 void updateViewCount(int bbsId) throws Exception;
	 
	 BbsDTO selectBbsDetail(int bbsId) throws Exception;
	 
	 void updateBbs(BbsDTO bbs) throws Exception;
	 
	 void deleteBbs(int bbsId) throws Exception;

	int getLatestBbsId();

	void insertHashtag(HashTag hashTag);

	BbsDTO getText();

	HashTag selectHashtag(HashTag hashTag);

	List<CommentDTO> getCommentsByBbsId(int bbsId) throws Exception;
}
