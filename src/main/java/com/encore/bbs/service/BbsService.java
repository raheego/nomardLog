package com.encore.bbs.service;

import com.encore.bbs.dto.Category;
import com.encore.bbs.dto.Post;
import com.encore.bbs.dto.Tag;

import java.util.List;

public interface BbsService {
    List<Category> getCategory();

    void saveTag(Tag tag);

    List<Post> getPost();

    void  savePostCateTag(Post post, Category category);

    Tag findById(Long id);
}
