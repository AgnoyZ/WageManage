package com.zhazhatao.wagemanage.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    @RequestMapping("")
    public String userMain(){
        return "user/main";
    }
}
