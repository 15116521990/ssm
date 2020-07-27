package com.zking.ssm.model;

import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.util.Date;


public class Bookfilevo extends bookfile implements Serializable {

    private Integer bookid;
    private MultipartFile file;
    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

   public  Bookfilevo(){

   }

    public Bookfilevo(Integer bookid, MultipartFile file) {
        this.bookid = bookid;
        this.file = file;
    }

    public Integer getBookid() {
        return bookid;
    }

    public void setBookid(Integer bookid) {
        this.bookid = bookid;
    }

}

