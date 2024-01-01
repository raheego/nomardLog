package com.example.bbs.mapper;

import com.example.bbs.domain.Post;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PostMapper {
    void insertPost(Post post);
}
