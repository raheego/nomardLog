package com.blog.member.service;

import org.springframework.stereotype.Service;

import com.blog.member.dto.MemberDTO;
import com.blog.member.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {
	private final MemberRepository memberRepository;

	public int save(MemberDTO memberDTO) {
		return memberRepository.save(memberDTO);
	}

	public boolean login(MemberDTO memberDTO) {
		MemberDTO loginMember = memberRepository.login(memberDTO);
		if(loginMember != null) {
			return true;
		} else {
			return false;
		}
		
	}
}
