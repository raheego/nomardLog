package com.encore.bbs.service;

import com.encore.bbs.dto.Tag;
import com.encore.bbs.mapper.BbsMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
class BbsServiceImplTest {

    @Autowired
    private BbsService bbsService;

//    @MockBean
    @Autowired
    private BbsMapper bbsMapper;

    @Test
    void getCategory() {
    }

    @Test
    void saveTag() {
        //given
        Tag tag = new Tag();
        tag.setContent("Test tag");

        //when
//        Tag saveTag = bbsService.saveTag(tag);
        bbsService.saveTag(tag); // 메서드 호출

        //then
//        Tag saveTag =
//        verify(bbsMapper, times(1)).saveTag();(mock테스트)
        assertNotNull(tag.getTagId());
        // Tag 객체가 데이터베이스에 성공적으로 저장되었을 경우, tagId (고유 식별자)가 null이 아닌지 확인합니다.
        assertEquals("Test tag", tag.getContent());
        //저장된 내용이 예상한것과 동일한지 확인("예상데이터", 저장된 데이터)

        Tag retrievedTag = bbsMapper.findById(tag.getTagId());
        //tagId(primarykey)를 통해 tag 객체를 검색
        assertNotNull(retrievedTag);
        // 검색된 Tag 객체가 null이 아닌지 확인합니다
        assertEquals(tag.getTagId(), retrievedTag.getTagId());
        // 원래 Tag 객체와 데이터베이스에서 검색된 Tag 객체의 tagId가 일치하는지 확인합니다.
        assertEquals("Test tag", retrievedTag.getContent());
        //검색된 Tag의 content가 예상한 값인 "Test tag"와 일치하는지 확인합니다
    }

    @Test
    void getPost() {
    }

    @Test
    void savePostCateTag() {
    }
}