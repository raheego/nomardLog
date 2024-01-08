package com.encore.bbs.member.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class MemberDTO { // DTO는 값을 받아서 '전달'하는 역할을 한다.
	
	@NotBlank
	private String memberId;
	
	@Size(min = 3, max = 20)
	private String memberPassword;
	
	
	private String memberName;
	
	@Email
	private String memberEmail;
	
	
	private Integer memberAge;
	
	
	private String memberMobile;

}