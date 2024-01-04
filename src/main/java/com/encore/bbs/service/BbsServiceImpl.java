package com.encore.bbs.service;

import com.encore.bbs.dto.Category;
import com.encore.bbs.dto.Post;
import com.encore.bbs.mapper.BbsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BbsServiceImpl implements BbsService{

    @Autowired
    private BbsMapper bbsMapper;
    @Override
    public List<Category> getCategory() {
        return bbsMapper.getCategory();
    }

    @Override
    public void saveTag() {
        bbsMapper.saveTag();
    }

    @Override
    public List<Post> getPost() {
        return bbsMapper.getPost();
    }

    @Override
    public void savePostCateTag(Post post, Category category) {
        bbsMapper.savePostCateTag(post, category);
    }
}
