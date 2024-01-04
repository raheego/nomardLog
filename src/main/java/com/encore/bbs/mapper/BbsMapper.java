package com.encore.bbs.mapper;

import com.encore.bbs.dto.Category;
import com.encore.bbs.dto.Post;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BbsMapper {
    List<Category> getCategory(); // select * from category; 셀렉트박스에 보여줄 쿼리

    void saveTag(); // insert into tag values(); // 태그 테이블 저장 시

    List<Post> getPost(); // select * from post; // 게시글 목록 활성 화 시

    void  savePostCateTag(Post post, Category category); // insert into post values(post, category)


}
