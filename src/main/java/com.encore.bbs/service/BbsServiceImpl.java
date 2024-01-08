package com.encore.bbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.encore.bbs.dto.BbsDTO;
import com.encore.bbs.mapper.BbsMapper;

@Service
public class BbsServiceImpl implements BbsService {
	
	@Autowired
	private BbsMapper bbsmapper;
	
	@Override
	public List<BbsDTO> selectBbsList() throws Exception {
		return bbsmapper.selectBbsList();
	}
		
	@Override
	public BbsDTO selectBbsDetail(int bbsId) throws Exception {
		BbsDTO bbs = bbsmapper.selectBbsDetail(bbsId);
		bbsmapper.updateViewCount(bbsId);
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

}
