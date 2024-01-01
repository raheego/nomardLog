package com.example.bbs.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class HashTag {
    Long tagId;
    String content;


    public HashTag(){}
    public HashTag(Long tagId, String content) {
        this.tagId = tagId;
        this.content = content;
    }
}
