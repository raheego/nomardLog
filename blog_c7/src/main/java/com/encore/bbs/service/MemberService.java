package com.encore.bbs.service;

import com.encore.bbs.dto.MemberDTO;

public interface MemberService {
	int save(MemberDTO memberDTO);
	boolean login(MemberDTO memberDTO);
}
