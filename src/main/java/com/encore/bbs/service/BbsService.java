package com.encore.bbs.service;

import com.encore.bbs.dto.Category;
import com.encore.bbs.dto.Post;

import java.util.List;

public interface BbsService {
    List<Category> getCategory();

    void saveTag();

    List<Post> getPost();

    void  savePostCateTag(Post post, Category category);
}
