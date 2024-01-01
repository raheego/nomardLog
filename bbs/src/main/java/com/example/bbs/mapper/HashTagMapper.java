package com.example.bbs.mapper;

import com.example.bbs.domain.HashTag;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HashTagMapper {

    void insertTag(HashTag hashTag);

    List<HashTag> hashTagList(); // 해쉬태그 담을 리스트

    HashTag findByHashTag(String content); //해당 태그 찾기

}
