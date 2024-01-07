package com.encore.bbs.dto;

import lombok.Data;

@Data
public class CommentDTO {
	String content;
	int likenum;
	String memberId;
}
