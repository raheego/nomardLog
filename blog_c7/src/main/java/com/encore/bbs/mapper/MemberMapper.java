package com.encore.bbs.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.encore.bbs.dto.MemberDTO;

@Mapper 
public interface MemberMapper {
    int save(MemberDTO memberDTO);

    MemberDTO login(MemberDTO memberDTO);
}