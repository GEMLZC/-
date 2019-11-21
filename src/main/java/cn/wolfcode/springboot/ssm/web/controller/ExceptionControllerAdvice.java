package cn.wolfcode.springboot.ssm.web.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice //控制器增强器
public class ExceptionControllerAdvice {
    
    @ExceptionHandler(Exception.class) //处理什么类型的异常
    public String handlException(Exception e, Model model) {
        model.addAttribute("msg", e.getMessage());
        return "errorView"; //逻辑视图名称
    }
}