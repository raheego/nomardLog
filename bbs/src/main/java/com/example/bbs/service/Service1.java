package com.example.bbs.service;

import com.example.bbs.domain.HashTag;

import java.util.List;

public interface Service1 {

    void save(HashTag hashTag);

    HashTag findByHashTag(String content);

    List<HashTag> allList();

}
