package com.sample.techpit.sample_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.servlet.ModelAndView;

import com.sample.techpit.sample_backend.model.User;
import com.sample.techpit.sample_backend.model.UserDto;
import com.sample.techpit.sample_backend.service.UserService;



@Controller
public class RegisterController {

        @Autowired
        private UserService userService;
    
        @GetMapping("/register")
        public ModelAndView registerForm() {
            ModelAndView mav = new ModelAndView();
            mav.addObject("user", new UserDto());
            mav.setViewName("register");
            return mav;
        }
    
        @PostMapping("/register")
        public String register(@ModelAttribute UserDto userDto) {
            User existing = userService.findByUsername(userDto.getUsername());
            if(existing != null){
                // ユーザが既に存在する場合の処理
                return "register"; // ユーザが存在するため、再度登録画面を表示
            }
            userService.save(userDto);
            return "login"; // 登録が成功した場合、ログイン画面を表示
        }
    
}
