package com.example.bbs.service;

import com.example.bbs.domain.Category;
import com.example.bbs.domain.HashTag;
import com.example.bbs.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements Service1{
    @Autowired
    private CategoryMapper categoryMapper;

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

    public List<Category> categoryList() {
        return categoryMapper.cateAllList();
    }
    public void findByCategory(Category category){
        categoryMapper.findByCategory(category);
    }

}
