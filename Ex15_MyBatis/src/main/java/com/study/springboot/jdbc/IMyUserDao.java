package com.study.springboot.jdbc;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper // 다음 인터페이스 구현을 XML로 구현
public interface IMyUserDao {
    List<MyUserDTO> list();
}
