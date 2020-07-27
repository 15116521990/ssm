package com.zking.ssm.service;

import com.zking.ssm.model.News;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface INewsservice {


    List<News> selectByPrimaryKey(Integer newsId);

}