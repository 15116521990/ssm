package com.zking.ssm.untity;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zking.ssm.model.Book;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Component  //注解@Component，将这个类放入容器中。
@Aspect //在头信息加入注解@Aspect。使用@Aspect 注解的类， Spring 将会把它当作一个特殊的Bean（一个切面，也就是不对这个类本身进行动态代理） 。
public class AopFiler {
    //第一个* 任意返回值  第二个*任意包名 ..下面所有子子孙孙 第三个*service 任意方法名以service结尾  .*(..) *pages带表任意方法以pages结尾 入参括号里面..任意入参

    @Around(value = "execution(* *..*.*pages(..))")//环绕通知拦截设置
     public Object inno(ProceedingJoinPoint po) throws Throwable {



       //获取所有入参
        Object[] args = po.getArgs();
        //接收参数
        PageBean pagebean=null;
        for (Object ar:args) {
               //判断参数里有没有分页参数
              if(ar instanceof  PageBean){
                  pagebean=(PageBean)ar;
                  break;
               }
        }
        //判断是否分页
        if (pagebean!=null&&pagebean.isPagination())
            PageHelper.startPage(pagebean.getPage(),pagebean.getRows()); //设置分页插件信息


        List<Book> proceed =(List<Book>) po.proceed(args);//重新设置入参执行方法
        PageInfo in=new PageInfo(proceed);

        return in.getList();
     }

}
