package com.encore.bbs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.encore.bbs.dto.BbsDTO;
import com.encore.bbs.dto.CommentDTO;
import com.encore.bbs.dto.MemberDTO;

@Mapper // @Mapper 어노테이션을 사용한 인터페이스는 MyBatis에 의해 구현체가 자동으로 생성되어 사용된다.
public interface MemberMapper {
    int save(MemberDTO memberDTO);

    MemberDTO login(MemberDTO memberDTO);

	List<BbsDTO> findByIdBbs(String loginId);

	List<CommentDTO> findByIdComment(String loginId);

	MemberDTO findByInfo(String loginId);

	int update(MemberDTO memberDTO);
}