package com.zking.ssm.service;

import com.zking.ssm.model.Book;
import com.zking.ssm.model.Bookfilevo;
import com.zking.ssm.model.bookfile;
import com.zking.ssm.untity.PageBean;

import java.util.List;

public interface IBookMapper {


    int insert(Book record);
    List<Book> querypages(Book record, PageBean pagebean);
    int updateByPrimaryKey( Bookfilevo vo);
    bookfile selectByPrimaryKey(String fileId);
}