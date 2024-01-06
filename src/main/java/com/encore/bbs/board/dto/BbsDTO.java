package com.encore.bbs.board.dto;

import java.time.LocalDateTime;

import lombok.*;

@Getter @Setter
@NoArgsConstructor
public class BbsDTO {

    private int bbsId;
    private int memberCode;
    private String title;
    private String contents;
    private LocalDateTime createdAt;
    private LocalDateTime modifyAt;
    private int viewCnt;
    private int likeCnt;
    private boolean isDeleted;
    private Long countryId;

    private String continentName;
    private String countryName;

    public BbsDTO(String continentName, String countryName) {
        this.continentName = continentName;
        this.countryName = countryName;
    }

    public BbsDTO(int memberCode, String title, String contents, LocalDateTime createdAt, LocalDateTime modifyAt, int viewCnt, int likeCnt, Long countryId) {
        this.memberCode = memberCode;
        this.title = title;
        this.contents = contents;
        this.createdAt = createdAt;
        this.modifyAt = modifyAt;
        this.viewCnt = viewCnt;
        this.likeCnt = likeCnt;
        this.countryId = countryId;
    }
}
