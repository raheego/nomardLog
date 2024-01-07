package com.encore.bbs.board.service;

import java.util.List;
import java.util.Optional;

import com.encore.bbs.board.dto.BbsDTO;
import com.encore.bbs.board.mapper.BbsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BbsServiceImpl implements BbsService {

    @Autowired
    private BbsMapper bbsmapper;


    @Override
    public List<BbsDTO> getBbsAllList() {
        return bbsmapper.getBbsAllList();
    }

    @Override
    public BbsDTO getText() {
        return bbsmapper.getText();
    }

//    @Override
//    public List<BbsDTO> getText(int bbsId) {
//        return bbsmapper.getText();
//    }

    @Override
    public void insertBbs(BbsDTO bbsDTO){
        bbsmapper.insertBbs(bbsDTO);
    }

    @Override
    public BbsDTO selectBbsDetail(int bbsId) {
            return bbsmapper.selectBbsDetail(bbsId);
    }

}
