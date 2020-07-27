package com.zking.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zking.ssm.model.Book;
import com.zking.ssm.model.Customer;
import com.zking.ssm.model.News;
import com.zking.ssm.model.Order;
import com.zking.ssm.service.IBookMapper;
import com.zking.ssm.service.ICustomerservice;
import com.zking.ssm.service.INewsservice;
import com.zking.ssm.service.IOrderservice;
import com.zking.ssm.untity.PageBean;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;
@Slf4j
public class IBookMapperImplTest extends BaseTest{
    @Autowired
    private IBookMapper ib;
    private Book b;


    @Autowired
    private IOrderservice o;
    @Autowired
    private ICustomerservice c;
    @Autowired
    private INewsservice ne;

    @Before
    public void setUp() throws Exception {
            b=new Book();
    }

    @Test
    public void insert() {
        b.setBookName("222");
        b.setBookType("222");
        b.setPrice(454);
        ib.insert(b);
    }

    @Test
    public void page() {
        PageBean pagebaen=new PageBean();
        b.setBookName("1");
        List<Book> querypages = ib.querypages(b, pagebaen);

        PageInfo page=new PageInfo(querypages);

        log.debug("111");
        System.out.println("页码：" + page.getPageNum());
        System.out.println("页大小：" + page.getPageSize());
        System.out.println("总记录：" + page.getTotal());
        querypages.forEach(System.out::println);



    }

    @Test
    public void test() {

//        List<Order> orders = o.selectByPrimaryKey(1);
//        orders.forEach(System.out::println);
//
//        Customer customer = c.selectByPrimaryKey(1);
//        System.out.println(customer);

        List<News> news = ne.selectByPrimaryKey(1);
        news.forEach(System.out::println);



    }
}