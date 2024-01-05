package com.encore.bbs.mapper;

import java.util.List;

import com.encore.bbs.dto.Category;
import com.encore.bbs.dto.Tag;
import org.apache.ibatis.annotations.Mapper;
import com.encore.bbs.dto.BbsDTO;

@Mapper
public interface BbsMapper {
	 List<BbsDTO> selectBbsList() throws Exception; 
	 
	 void insertBbs(BbsDTO bbs) throws Exception;

	List<Category> getCategory(); // select * from category; 셀렉트박스에 보여줄 쿼리

	void saveTag(Tag tag); // insert into tag values(); // 태그 테이블 저장 시


	Tag findById(Long id);
}
