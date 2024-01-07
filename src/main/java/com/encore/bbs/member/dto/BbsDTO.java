package com.encore.bbs.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class BbsDTO {

	private int bbsId;
	private int memberCode;
	private String title;
	private String contents;
	private LocalDateTime createdAt;
	private LocalDateTime modifyAt;
	private int viewCnt;
	private int likeCnt;
	private int tagId;
	private boolean isDeleted;
}
