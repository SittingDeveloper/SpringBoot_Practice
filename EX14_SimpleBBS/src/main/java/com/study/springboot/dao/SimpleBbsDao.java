package com.study.springboot.dao;

import com.study.springboot.dto.SimpleBbsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SimpleBbsDao implements ISimpleBbsDao{

    @Autowired
    JdbcTemplate template;

    @Override
    public List<SimpleBbsDto> listDao() { // 여러 결과값을 출력하니 List 안에 담아서 출력
        System.out.println("listDao()");

        String query = "select * from simple_bbs order by id desc";
        List<SimpleBbsDto> dtos = template.query(
                query, new BeanPropertyRowMapper<SimpleBbsDto>(SimpleBbsDto.class));
        return dtos;
    }

    @Override
    public SimpleBbsDto viewDao(String id) { // 한 결과값만 출력하면 되니 SimpleBbsDto에 바로 담아서 출력
        System.out.println("viewDao()");

        String query = "select * from simple_bbs where id = " + id;
        SimpleBbsDto dto = template.queryForObject(
                query, new BeanPropertyRowMapper<SimpleBbsDto>(SimpleBbsDto.class));

        return dto;
    }

    @Override
    public int writeDao(final String writer, final String title, final String content) {
        System.out.println("writeDao()");

        String query =
                "insert into simple_bbs(writer, title, content)" +
                        "values(?,?,?)";

        return template.update(query, writer, title, content);
    }

    @Override
    public int deleteDao(final String id) {
        System.out.println("deleteDao()");

        String query = "delete from simple_bbs where id = ?";
        return template.update(query, Integer.parseInt(id));
    }

}
