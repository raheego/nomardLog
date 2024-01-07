package com.encore.bbs.board.mapper;

import java.util.List;

import com.encore.bbs.board.dto.BbsDTO;
import com.encore.bbs.board.dto.HashTag;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface BbsMapper {
    List<BbsDTO> getBbsAllList();

    //    BbsDTO getText(int bbsId); // 게시글 내용 불러오기
    BbsDTO getText(); // 게시글 내용 불러오기

    void insertBbs(BbsDTO bbsDTO);

    BbsDTO selectBbsDetail(int bbsId);

    List<BbsDTO> getCountryList();

//    Long insertCountryBbs(@Param("countryName") String countryName);
    void insertCountryBbs(BbsDTO bbsDTO); // 테스트중

    void insertHashtag(HashTag hashTag);
}
