package com.zking.ssm.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class Book {

    // 书本验证分组
    public static interface ValidateGroups {
        // 新增/修改
        public static interface Add {
        }

        // 上架/下架
        public static interface Edit {
        }

        // 更新封面
        public static interface UpdateBookImage {
        }
    }

    @NotBlank(message = "id不能为null",groups = { ValidateGroups.Edit.class})
    private Integer id;
    @NotBlank(message = "书本名字不能为null",groups = {ValidateGroups.Add.class, ValidateGroups.Edit.class})
    private String bookName;
    @NotNull(message = "书本价格不能为null",groups = {ValidateGroups.Add.class, ValidateGroups.Edit.class})
    private Integer price;
    @NotBlank(message = "书本类型不能为null",groups = {ValidateGroups.Add.class, ValidateGroups.Edit.class})
    private String bookType;
    private String bookImg;

    public String getBookImg() {
        return bookImg;
    }

    public void setBookImg(String bookImg) {
        this.bookImg = bookImg;
    }

    public Book(Integer id, String bookName, Integer price, String bookType) {
        this.id = id;
        this.bookName = bookName;
        this.price = price;
        this.bookType = bookType;
    }

    public Book() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getBookType() {
        return bookType;
    }

    public void setBookType(String bookType) {
        this.bookType = bookType;
    }
}