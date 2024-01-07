package com.encore.bbs.board.service;


import com.encore.bbs.board.dto.BbsDTO;
import com.encore.bbs.board.dto.HashTag;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BbsService {

    List<BbsDTO> getBbsAllList();

    //    BbsDTO getText(int bbsId);
    BbsDTO getText();

    void insertBbs(BbsDTO bbsDTO);

    BbsDTO selectBbsDetail(int bbsId);

    List<BbsDTO> getCountryList();

//    Long insertCountryBbs(@Param("countryName") String countryName);

    void insertCountryBbs(BbsDTO bbsDTO);

    void insertHashtag(HashTag hashTag);

}
