package com.example.bbs.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HashTagMapping {

    int tagId;
    int tagCount;
    int weekCount;

    public HashTagMapping(int tagCount, int weekCount) {
        this.tagCount = tagCount;
        this.weekCount = weekCount;
    }
}
