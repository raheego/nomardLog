package com.encore.bbs.dto;

import lombok.Data;

@Data
public class MemberDTO { // DTO는 값을 받아서 '전달'하는 역할을 한다.
	private String memberId;
	private String memberPassword;
	private String memberName;
	private String memberEmail;
	private Integer memberAge;
	private String memberMobile;

}