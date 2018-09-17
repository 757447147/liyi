package com.pinyougou.shop.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("login")
public class LoginController {
    /**
     * 从security认证信息中获取当前登录的用户信息
     * @return
     */
    @GetMapping("getUsername")
    public Map<String,String> getUsername(){
        Map<String,String> map = new HashMap<>();

        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        map.put("username",name);

        return map;
    }
}
