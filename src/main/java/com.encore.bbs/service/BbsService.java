package com.encore.bbs.service;

import java.util.List;
import com.encore.bbs.dto.BbsDTO;


public interface BbsService {
	
	 List<BbsDTO> selectBbsList() throws Exception ;
	 
	 void insertBbs(BbsDTO bbs) throws Exception;


}