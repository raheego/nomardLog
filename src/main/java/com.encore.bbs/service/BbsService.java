package com.encore.bbs.service;

import java.util.List;
import com.encore.bbs.dto.BbsDTO;
import com.encore.bbs.dto.Category;
import com.encore.bbs.dto.Tag;


public interface BbsService {
	
	 List<BbsDTO> selectBbsList() throws Exception ;
	 
	 void insertBbs(BbsDTO bbs) throws Exception;

	List<Category> getCategory();

	void saveTag(Tag tag);

	Tag findById(Long id);

}
