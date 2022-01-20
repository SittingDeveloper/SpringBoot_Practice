package com.study.springboot.dao;

import com.study.springboot.dto.SimpleBbsDto;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper // 다음 인터페이스의 구현을 .xml 로 구현
public interface ISimpleBbsDao {
    public List<SimpleBbsDto> listDao();
    public SimpleBbsDto viewDao(String id);
    public int writeDao(Map<String, String> map);
    public int deleteDao(@Param("_id") String id);
    public int articleCount();
}