package com.encore.bbs.board.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BbsDto {

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
