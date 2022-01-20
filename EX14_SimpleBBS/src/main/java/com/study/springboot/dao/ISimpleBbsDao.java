package com.study.springboot.dao;

import com.study.springboot.dto.SimpleBbsDto;

import java.util.List;

public interface ISimpleBbsDao {

    // 리스트를 보기 위한 Select 메서드
    public List<SimpleBbsDto> listDao();

    // 개별 뷰를 보기 위한 select 메서드
    public SimpleBbsDto viewDao(String id);

    // 글 작성을 위한 insert 메서드
    public int writeDao(String writer, String title, String content);

    // 글 삭제를 위한 delete 메서드
    public int deleteDao(String id);

}