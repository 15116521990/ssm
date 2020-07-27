package com.zking.ssm.mapper;

import com.zking.ssm.model.bookfile;
import org.springframework.stereotype.Repository;

@Repository
public interface bookfileMapper {
    int deleteByPrimaryKey(String fileId);

    int insert(bookfile record);

    int insertSelective(bookfile record);

    bookfile selectByPrimaryKey(String fileId);

    int updateByPrimaryKeySelective(bookfile record);

    int updateByPrimaryKey(bookfile record);
}