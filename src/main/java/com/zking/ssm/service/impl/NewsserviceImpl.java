package com.zking.ssm.service.impl;

import com.zking.ssm.mapper.NewsMapper;
import com.zking.ssm.model.News;
import com.zking.ssm.service.INewsservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class NewsserviceImpl implements INewsservice {
    @Autowired
    private NewsMapper n;
    @Override
    public List<News> selectByPrimaryKey(Integer newsId) {
        return n.selectByPrimaryKey(newsId);
    }
}
