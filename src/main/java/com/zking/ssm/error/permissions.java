package com.zking.ssm.error;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
@Slf4j
@ResponseBody
public class permissions {
     @ExceptionHandler(UnauthorizedException.class)
    public Map<String,Object> setpo(UnauthorizedException e){
         Map<String,Object> na=new HashMap<>();
         na.put("msg","权限异常");
         na.put("异常",e.getMessage());
           return na;
    }




}
