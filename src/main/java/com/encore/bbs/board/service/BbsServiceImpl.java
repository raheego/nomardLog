package com.encore.bbs.board.service;

import java.util.List;

import com.encore.bbs.board.dto.BbsDTO;
import com.encore.bbs.board.dto.HashTag;
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

    @Override
    public void insertBbs(BbsDTO bbsDTO) {
        bbsmapper.insertBbs(bbsDTO);
    }

    @Override
    public BbsDTO selectBbsDetail(Long bbsId) {
        return bbsmapper.selectBbsDetail(bbsId);
    }

    @Override
    public List<BbsDTO> getCountryList() {
        return bbsmapper.getCountryList();
    }

    @Override
    public void insertCountryBbs(BbsDTO bbsDTO) {
        bbsmapper.insertCountryBbs(bbsDTO);
    }

    @Override
    public void insertHashtag(BbsDTO bbsDTO, String content) {
        //게시글 저장 실행
        bbsmapper.insertBbs(bbsDTO);

        //게시글 저장 아이디 반환(getLatestBbsId 추가 service)
        Long savedBbsId = bbsmapper.getLatestBbsId();

        // 해시태그 저장을 위한 객체 생성
        HashTag hashTag = new HashTag();
        hashTag.setBbsId(savedBbsId); // 해당 객체에 저장아이디 반환
        hashTag.setContent(content); // 해당 객체에 작성한 내용 반환

        bbsmapper.insertHashtag(hashTag); // 해시태그 테이블 저장 서비스
    }

    @Override
    public Long getLatestBbsId() {
        return bbsmapper.getLatestBbsId();
    }



@Override
    public HashTag selectHashtag(BbsDTO bbsDTO, Long bbsId) {
        bbsDTO = bbsmapper.selectBbsDetail(bbsId);

        Long getId = bbsDTO.getBbsId();

        HashTag hashTag = new HashTag();
        hashTag.setBbsId(bbsId);

        return bbsmapper.selectHashtag(hashTag);
    }

//    @Override
//    public void insertHashtag(BbsDTO bbsDTO, String content) {
//        bbsmapper.insertBbs(bbsDTO);
//
//        Long savedBbsId = bbsmapper.get
//        HashTag hashTag = new HashTag();
//        // HashTag 저장을 위해 임시로 bbsId를 설정
//        hashTag.setBbsId(bbsDTO.getBbsId());
//
//        bbsmapper.insertHashtag(hashTag);
//    }

//    @Override
//    public Long insertCountryBbs(String countryName) {
//        return bbsmapper.insertCountryBbs(countryName);
//    }

}


