package com.encore.bbs.board.service;


import com.encore.bbs.board.dto.BbsDTO;

import java.util.List;

public interface BbsService {

    List<BbsDTO> getBbsAllList();

    void insertBbs(BbsDTO bbsDTO);

    BbsDTO selectBbsDetail(int bbsId);


}
