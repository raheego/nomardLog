package com.encore.bbs.service;

import java.util.List;

import com.encore.bbs.dto.CommentDTO;
import com.encore.bbs.dto.HashTag;
import com.encore.bbs.mapper.BbsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.encore.bbs.dto.BbsDTO;


@Service
public class BbsServiceImpl implements BbsService {
	
	@Autowired
	private BbsMapper bbsmapper;
	
	@Override
	public List<BbsDTO> selectBbsList() throws Exception {
		return bbsmapper.selectBbsList();
	}

	@Override
	public void insertBbs(BbsDTO bbs, MultipartHttpServletRequest multipartHttpServletRequest, String content) throws Exception {
		bbsmapper.insertBbs(bbs);
		int savedBbsId = bbsmapper.getLatestBbsId();

		// 해시태그 저장을 위한 객체 생성
		HashTag hashTag = new HashTag();
		hashTag.setBbsId(savedBbsId); // 해당 객체에 저장아이디 반환
		hashTag.setContent(content); // 해당 객체에 작성한 내용 반환

		bbsmapper.insertHashtag(hashTag); // 해시태그 테이블 저장 서비스
	}
//	@Override
//	public void insertHashtag(BbsDTO bbsDTO, String content) throws Exception {
//		bbsmapper.insertBbs(bbsDTO);
//
//		//게시글 저장 아이디 반환(getLatestBbsId 추가 service)
//		int savedBbsId = bbsmapper.getLatestBbsId();
//
//		// 해시태그 저장을 위한 객체 생성
//		HashTag hashTag = new HashTag();
//		hashTag.setBbsId(savedBbsId); // 해당 객체에 저장아이디 반환
//		hashTag.setContent(content); // 해당 객체에 작성한 내용 반환
//
//		bbsmapper.insertHashtag(hashTag); // 해시태그 테이블 저장 서비스
//	}

	@Override
	public BbsDTO selectBbsDetail(int bbsId) throws Exception {
		BbsDTO bbs = bbsmapper.selectBbsDetail(bbsId);
		bbsmapper.getCommentsByBbsId(bbsId);
		bbsmapper.updateViewCount(bbsId); // sql 합쳐서 할 수 있을 거 같은디
		return bbs;
	}
	
	@Override
	public void updateBbs(BbsDTO bbs) throws Exception {
	  bbsmapper.updateBbs(bbs);
	}
	
	@Override
	public void deleteBbs(int bbsId) throws Exception {
		bbsmapper.deleteBbs(bbsId);

	}

	@Override
	public int getLatestBbsId() throws Exception {
		return bbsmapper.getLatestBbsId();
	}


	@Override
	public BbsDTO getText() throws Exception{
		return bbsmapper.getText();
	}



	@Override
	public HashTag selectHashtag(BbsDTO bbsDTO, int bbsId) throws Exception {
//		bbsDTO = bbsmapper.selectBbsDetail(bbsId);

		int getId = bbsDTO.getBbsId();

		HashTag hashTag = new HashTag();
		hashTag.setBbsId(bbsId);

		return bbsmapper.selectHashtag(hashTag);
	}

	@Override
	public List<CommentDTO> getCommentsByBbsId(int bbsId) throws Exception {
		return bbsmapper.getCommentsByBbsId(bbsId);
	}

}
