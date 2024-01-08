package com.encore.bbs.member.service;

import java.util.List;

import com.encore.bbs.member.dto.BbsDTO;
import com.encore.bbs.member.dto.CommentDTO;
import com.encore.bbs.member.dto.MemberDTO;

public interface MemberService {
	int save(MemberDTO memberDTO);
	boolean login(MemberDTO memberDTO);
//	List<MemberDTO> findById();
	List<BbsDTO> findByIdBbs(String loginId);
	List<CommentDTO> findByIdComment(String loginId);
	MemberDTO findByIdInfo(String loginId);
	boolean update(MemberDTO memberDTO);
	String idCheck(String memberId);
}
