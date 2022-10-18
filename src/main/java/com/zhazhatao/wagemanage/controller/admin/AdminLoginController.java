package com.zhazhatao.wagemanage.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpSession;

@Controller
public class AdminLoginController {

    @RequestMapping("/admin")
    public String toLogin(){
        return "admin/login";
    }

    @RequestMapping("/admin/login")
    public String login(String userName, int jobId,HttpSession session){
        session.setAttribute("userName",userName);
        session.setAttribute("jobId",jobId);
        if (jobId == 2){
            return "redirect:/admin/wageConfig";
        }
        return "redirect:/admin/employeeManage";
    }

    @RequestMapping("/admin/loginOut")
    public String loginOut(HttpSession session){
        session.invalidate();
        return "redirect:";
    }
}
