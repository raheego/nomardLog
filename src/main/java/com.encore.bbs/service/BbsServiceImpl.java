package com.encore.bbs.service;

import java.util.List;

import com.encore.bbs.dto.Category;
import com.encore.bbs.dto.Tag;
import com.encore.bbs.mapper.BbsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.encore.bbs.dto.BbsDTO;

@Service
public class BbsServiceImpl implements BbsService {
	
	@Autowired
	private BbsMapper bbsmapper;


	@Override
	public List<BbsDTO> selectBbsList() throws Exception {
		return null;
	}

	@Override
	public void insertBbs(BbsDTO bbs) throws Exception {
	}

	@Override
	public List<Category> getCategory() {
		return bbsmapper.getCategory();
	}

	@Override
	public void saveTag(Tag tag) {
		bbsmapper.saveTag(tag);
	}


	@Override
	public Tag findById(Long id) {
		return null;
	}
}
