package com.encore.bbs.mapper;

import com.encore.bbs.board.mapper.BbsMapper;
import com.encore.bbs.board.service.BbsService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

//@SpringBootTest
//public class testMapper {
//    @Autowired
//    private BbsMapper bbsMapper;
//    @Autowired
//    private BbsService bbsService;

//    @Test
//    @DisplayName("DB연결 후 조회 테스트")
//    public void testBbsDetail(){
//        try {
//            List<BbsDTO> bbsDetail = bbsMapper.selectBbsDetail(bbsId);
//            assertNotNull(bbsDetail);
//            assertTrue(bbsDetail.size() > 0);
//            BbsDTO firstBbs = bbsDetail.get(0);
//            assertNotNull(firstBbs);
//            assertTrue(firstBbs.getBbsId() > 0);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

//    @Test
//    public void testMapping() {
//        assertThrows(Exception.class, () -> {
//            bbsMapper.selectBbsDetail();
//            }, "Expected BindingException was not thrown.");
//    }

//    @Test
//    @DisplayName("대륙 DB연결 후 조회 테스트")
//    public void testContinent(){
//            Long continentId = 1L;
//
//            ContinentDto continentDto = bbsMapper.getContinentByCountryId(continentId);
//
//            assertNotNull(continentDto);
//            assertEquals(continentId, continentDto.getContinentId());
//        }
//    @Test
//    @DisplayName("매퍼 붙는 테스트")
//    public void testMapping() {
//        Long continentId = 1L;
//
//        assertThrows(Exception.class, () -> {
//            bbsMapper.getContinentByCountryId(continentId);
//            }, "Expected BindingException was not thrown.");
//    }
//
//    @Test
//    @DisplayName("서비스 테스트")
//    public void testService(){
//        Long continentId = 1L;
//
//        ContinentDto resultContinentDto = bbsService.getContinentByCountryId(continentId);
//
//        assertNotNull(resultContinentDto);
//        assertEquals(continentId, resultContinentDto.getContinentId());
//        assertNotNull(resultContinentDto.getContinentName());
//    }
//    }

