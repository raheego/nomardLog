package com.example.bbs.service;

import com.example.bbs.domain.HashTag;
import com.example.bbs.domain.Post;
import com.example.bbs.mapper.HashTagMapper;
import com.example.bbs.mapper.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HashTagService implements Service1{

    @Autowired
    private PostMapper postMapper;

    @Autowired
    private HashTagMapper hashTagMapper;


    @Override
    public void save(HashTag hashTag) {

    }

    @Override
    public HashTag findByHashTag(String content) {
        return null;
    }

    @Override
    public List<HashTag> allList() {
        return null;
    }

    public void savePostWithHashtags(Post post, String hashtagsStr) {
        // 게시글 저장
        postMapper.insertPost(post);
        // 쉼표로 해시태그 분리, 각 해시태그를 저장 및 게시글에 연결
        String[] hashtagArray = hashtagsStr.split(",");
        for (String tagContent : hashtagArray) {
            tagContent = tagContent.trim();

            //존재 확인
            HashTag existHashtag = hashTagMapper.findByHashTag(tagContent);

            if (existHashtag == null) {
                HashTag newHashtag = new HashTag();
                newHashtag.setContent(tagContent);
                hashTagMapper.insertTag(newHashtag);
            }
        }
    }
}
