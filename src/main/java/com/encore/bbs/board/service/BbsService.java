package com.encore.bbs.board.service;


import com.encore.bbs.board.dto.BbsDTO;

import java.util.List;

public interface BbsService {

    List<BbsDTO> selectBbsList() throws Exception ;

    void insertBbs(BbsDTO bbs) throws Exception;

    BbsDTO selectBbsDetail(int bbsId);


}
