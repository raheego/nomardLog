package com.encore.bbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
	public void insertBbs(BbsDTO bbs) throws Exception {
		bbsmapper.insertBbs(bbs);
	}

}
