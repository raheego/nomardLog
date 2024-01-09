package com.encore.bbs.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class HashTag {
    private int hashtagId;
    private String content;
    private int bbsId;

    public HashTag(String content, int bbsId) {
        this.content = content;
        this.bbsId = bbsId;
    }
}
