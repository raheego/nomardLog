package com.encore.bbs.board.mapper;

import java.util.List;

import com.encore.bbs.board.dto.BbsDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BbsMapper {
    List<BbsDTO> selectBbsList() throws Exception;

    void insertBbs(BbsDTO bbs) throws Exception;

    BbsDTO selectBbsDetail(int bbsId);

}
