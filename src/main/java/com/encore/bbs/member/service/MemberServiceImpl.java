package com.encore.bbs.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.encore.bbs.dto.BbsDTO;
import com.encore.bbs.dto.CommentDTO;
import com.encore.bbs.dto.MemberDTO;
import com.encore.bbs.mapper.MemberMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
	private final MemberMapper memberMapper;

	public int save(MemberDTO memberDTO) {
		return memberMapper.save(memberDTO);
	}

	public boolean login(MemberDTO memberDTO) {
		MemberDTO loginMember = memberMapper.login(memberDTO);
		if(loginMember != null) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public List<BbsDTO> findByIdBbs(String loginId) {
		return memberMapper.findByIdBbs(loginId);
	}

	@Override
	public List<CommentDTO> findByIdComment(String loginId) {
		return memberMapper.findByIdComment(loginId);
	}

	@Override
	public MemberDTO findByIdInfo(String loginId) {
		return memberMapper.findByInfo(loginId);
	}

	@Override
	public boolean update(MemberDTO memberDTO) {
		int updateResult = memberMapper.update(memberDTO);
		if (updateResult > 0) {
			return true;
		} else {
			return false;
		}
		
	}

	@Override
	public String idCheck(String memberId) {
		MemberDTO memberDTO = memberMapper.findByInfo(memberId);
		if (memberDTO == null) {
			return "ok";
		} else {
			return "no";
		}
	}

}