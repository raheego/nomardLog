package com.encore.bbs.board.service;


import com.encore.bbs.board.dto.BbsDTO;
import com.encore.bbs.board.dto.HashTag;

import java.util.List;

public interface BbsService {

    List<BbsDTO> getBbsAllList();

    //    BbsDTO getText(int bbsId);
    BbsDTO getText();

    void insertBbs(BbsDTO bbsDTO);

    BbsDTO selectBbsDetail(Long bbsId);

    List<BbsDTO> getCountryList();

//    Long insertCountryBbs(@Param("countryName") String countryName);

    void insertCountryBbs(BbsDTO bbsDTO);

//    void insertHashtag(HashTag hashTag);
    void insertHashtag(BbsDTO bbsDTO, String content);

    Long getLatestBbsId();

//    BbsDTO selectHashtag(BbsDTO bbsDTO);

    HashTag selectHashtag(BbsDTO bbsDTO, Long bbsId);
}
