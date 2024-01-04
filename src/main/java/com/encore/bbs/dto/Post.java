package com.encore.bbs.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class Post {
    private int bbsId;
    private String title;
    private String contents;
    private LocalDate createdAt;
    private int viewCnt;
    private int likeCnt;
    private String tagContent;

    public Post(int bbsId, String title, String contents, String tagContent) {
        this.bbsId = bbsId;
        this.title = title;
        this.contents = contents;
        this.tagContent = tagContent;
    }
}
