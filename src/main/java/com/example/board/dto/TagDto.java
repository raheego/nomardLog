package com.example.board.dto;

import lombok.Data;

@Data
public class TagDto {
    private int tagCode;
    private String tagContent;

    public TagDto(int tagCode, String tagContent) {
        this.tagCode = tagCode;
        this.tagContent = tagContent;
    }
}
