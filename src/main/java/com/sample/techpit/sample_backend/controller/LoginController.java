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
        if (authentication != null && authentication.isAuthenticated()) {
            return "redirect:/index";  
        }
        return "redirect:/login";
    }
    
    @GetMapping("/index")
    public String index() {
        return "index";
    }
    
}
