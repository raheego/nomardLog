package com.encore.bbs.board.mapper;

import java.util.List;
import java.util.Optional;

import com.encore.bbs.board.dto.BbsDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BbsMapper {
    List<BbsDTO> getBbsAllList();

    //    BbsDTO getText(int bbsId); // 게시글 내용 불러오기
    BbsDTO getText(); // 게시글 내용 불러오기

    void insertBbs(BbsDTO bbsDTO);

    BbsDTO selectBbsDetail(int bbsId);

}
