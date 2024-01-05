package com.encore.bbs.service;

import org.springframework.stereotype.Service;

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
}