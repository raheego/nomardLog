package com.example.bbs.domain;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Category {
    private Long cateId;
    private String content;

    public Category() {}

    public Category(String content) {
        this.content = content;
    }
}
