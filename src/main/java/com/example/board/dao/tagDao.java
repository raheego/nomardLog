package com.example.board.dao;

import com.example.board.data.Tag;

public interface tagDao { // 실제로 DB에 접근하여 CRUD기능을 수행 service와 DB를 연결하는 고리

    Tag insertTag(Tag tag);

    Tag selectTag(int tagCode);

    Tag deleteTag(int tagCode);

}
