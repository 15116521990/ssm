package com.zking.ssm.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zking.ssm.model.Book;
import com.zking.ssm.model.Bookfilevo;
import com.zking.ssm.model.bookfile;
import com.zking.ssm.service.IBookMapper;
import com.zking.ssm.untity.PageBean;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
@Slf4j
@Controller
public class home {
       @Autowired
       private IBookMapper b;
       @RequestMapping(value={"/"})
       public ModelAndView home(HttpServletRequest req, Book book){


            ModelAndView m=new ModelAndView();
           m.setViewName("login");

           return m;
}

    @RequiresPermissions(value = "bookmanager:book:edit")
    @RequestMapping(value={"/list"})
    public ModelAndView listquer(HttpServletRequest req, Book book){


        ModelAndView m=new ModelAndView();
        m.setViewName("book/booklist");
        PageBean page=new PageBean();
        page.setRequest(req);
        List<Book> querypages = b.querypages(book, page);

        m.addObject(querypages);
        return m;
    }
    @RequestMapping(value={"/json"})
    @ResponseBody
    public  List<Book> homejson(HttpServletRequest req, Book book) throws Exception {



        PageBean page=new PageBean();
        page.setRequest(req);
        List<Book> querypages = b.querypages(book, page);


        return querypages;
    }

       @RequestMapping("/addbook")
       public  String addbook(@Validated(Book.ValidateGroups.Add.class) @ModelAttribute Book book, BindingResult result, Model m){
           if(result.hasErrors()){
                  m.addAttribute("msg","验证异常");
                  m.addAttribute("book",book);
                  return "book/addbook";
           }
           b.insert(book);

           return "redirect:/";
       }

    @RequestMapping("/addfil")
    public  String addfile(HttpServletRequest request,Bookfilevo book) throws Exception {
        System.out.println("上传文件");
        //根据路径 获得绝对路径
        String path=this.topath(request,"img");
        //得到传入文件
        MultipartFile file = book.getFile();
        //获取储存的文件夹
        File p=new File(path);
        //判断文件夹是否存在
        //否 则创建文件夹
        if(!p.exists()&&!p.isDirectory())
            p.mkdir();
        //拼接文件路径名称
        String pathmir=path+File.separator+file.getOriginalFilename();
        //新建文件名字
        File fi=new File(pathmir);
        //根据文件名字另存为项目img文件夹
        file.transferTo(fi);
        //判断是否另存为成功
        if(!fi.exists()){
            return "book/addfile";
        }

        //将信息存入图片数据库 并绑定书本
        b.updateByPrimaryKey(book);







        return "redirect:/";
//        return "/addfile";
    }

    @RequestMapping("/fileimg")
    public ResponseEntity<byte[]> fileimg(HttpServletRequest request, @RequestParam String fileId) throws Exception {

           //根据id查询图片信息
        bookfile bookFile = b.selectByPrimaryKey(fileId);
        System.out.println(fileId);
        //根据路径 获得绝对路径
        String path=this.topath(request,"img");


        //拼接文件路径名称
        String pathmir=path+File.separator+bookFile.getRealName();



        //下载关键代码
        File file=new File(pathmir);
        HttpHeaders headers = new HttpHeaders();//http头信息
        String downloadFileName = new String(bookFile.getRealName().getBytes("UTF-8"),"iso-8859-1");//设置编码
        headers.setContentDispositionFormData("attachment", downloadFileName);
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        //MediaType:互联网媒介类型  contentType：具体请求中的媒体类型信息
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),headers, HttpStatus.OK);

}



//转换绝对路径
public String topath(HttpServletRequest request,String path) {
    System.out.println(request.getSession().getServletContext().getRealPath(path));
    return request.getSession().getServletContext().getRealPath(path);
}
}