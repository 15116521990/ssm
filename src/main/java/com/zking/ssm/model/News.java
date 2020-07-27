package com.zking.ssm.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class News {
    private Integer newsId;

    private String title;
     private List<Category> cate=new ArrayList<>();

    public List<Category> getCate() {
        return cate;
    }

    public void setCate(List<Category> cate) {
        this.cate = cate;
    }

    public News(Integer newsId, String title) {
        this.newsId = newsId;
        this.title = title;
    }

    public News() {
        super();
    }

    public Integer getNewsId() {
        return newsId;
    }

    public void setNewsId(Integer newsId) {
        this.newsId = newsId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}