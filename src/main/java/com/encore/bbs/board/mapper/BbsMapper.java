package com.encore.bbs.board.mapper;

import java.util.List;

import com.encore.bbs.board.dto.BbsDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BbsMapper {
    List<BbsDTO> getBbsAllList();

    void insertBbs(BbsDTO bbsDTO);

    BbsDTO selectBbsDetail(int bbsId);

}
