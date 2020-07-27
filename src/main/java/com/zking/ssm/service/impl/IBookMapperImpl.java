package com.zking.ssm.service.impl;

import com.zking.ssm.mapper.BookMapper;
import com.zking.ssm.mapper.bookfileMapper;
import com.zking.ssm.model.Book;
import com.zking.ssm.model.Bookfilevo;
import com.zking.ssm.model.bookfile;
import com.zking.ssm.service.IBookMapper;
import com.zking.ssm.untity.PageBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.annotation.Transient;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
@Slf4j
@Service
public class IBookMapperImpl implements IBookMapper {

   @Autowired
   private BookMapper b;
   @Autowired
   private bookfileMapper bfi;
    @Override
    public int insert(Book record) {
        return b.insert(record);
    }


    @Override
    public List<Book> querypages(Book record, PageBean pagebean) {
        return b.querypages(record);
    }
    @Transactional
    @Override
    public int updateByPrimaryKey( Bookfilevo vo) {
        Book record=new Book();
        vo.setFileId(UUID.randomUUID().toString().replace("-",""));
        vo.setContentType(vo.getFile().getContentType());
        vo.setRealName(vo.getFile().getOriginalFilename());
        int insert = bfi.insert(vo);
        if(insert<0)
             log.debug("增加图片信息错误");

         record.setId(vo.getBookid());
         record.setBookImg(vo.getFileId());
        int i = b.updateByPrimaryKey(record);
            if(i<0)
                log.debug("修改书本img错误");
        return 1;
    }

    @Override
    public bookfile selectByPrimaryKey(String fileId) {

        return bfi.selectByPrimaryKey(fileId);
    }

}
