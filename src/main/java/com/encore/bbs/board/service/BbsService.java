package com.encore.bbs.board.service;


import com.encore.bbs.board.dto.BbsDTO;

import java.util.List;
import java.util.Optional;

public interface BbsService {

    List<BbsDTO> getBbsAllList();

    //    BbsDTO getText(int bbsId);
    BbsDTO getText();

    void insertBbs(BbsDTO bbsDTO);

    BbsDTO selectBbsDetail(int bbsId);


}
