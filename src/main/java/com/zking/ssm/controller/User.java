package com.zking.ssm.controller;

import com.zking.ssm.model.SysUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class User {



    @RequestMapping("login")
    public String login(SysUser s, Model m){

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken n=new UsernamePasswordToken(s.getUsername(),s.getPassword());


        try {
            subject.login(n);
        } catch (UnknownAccountException e) {
            m.addAttribute("massage",e.getMessage());
            return "login";

        } catch (IncorrectCredentialsException ice){
            m.addAttribute("massage","密码错误");
            return "login";

        }

            return "redirect:/list";
    };
}
