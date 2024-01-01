package com.example.bbs.domain;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Post {
    private Long id;
    private String content;

    public Post(){}

    public Post(String content) {
        this.content = content;
    }
}
