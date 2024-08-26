package com.sample.techpit.sample_backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;


@Controller
public class LoginController {
    @GetMapping("/login")
    public String login() {
        return "login";  
    }
    
    @GetMapping("/")
    public String redirectToIndex() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {//認証OKなら
             return "redirect:/top"; 
            // return "redirect:/index"; 
            
        }
        
        return "index";//機能してない。SecurityConfigの.formLogin強いので、認証時は基本的にログイン画面に遷移する
        //でもないファイルを設定するとエラーになるので、注意。

    }
    
    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/top")
    public String top() {
        return "top";
    }

     @GetMapping("/test")
    public String test() {
        return "test";
    }
    


    // @GetMapping("/login")
    // public String login() {
    //     return "login";  
    // }
    
    // @GetMapping("/")
    // public String redirectToIndex() {
    //     Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    //     if (authentication != null && authentication.isAuthenticated()) {
    //         return "redirect:/index";  
    //     }
    //     return "redirect:/login";
    // }
    
    // @GetMapping("/index")
    // public String index() {
    //     return "index";
    // }





}


