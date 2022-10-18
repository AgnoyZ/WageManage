package com.zhazhatao.wagemanage.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminViewController extends AdminBaseController{
    @RequestMapping("/admin/employeeManage")
    public String employeeManage(){
        return "admin/employeeManage";
    }
    @RequestMapping("/admin/wageConfig")
    public String wageMange(){
        return "admin/wageConfig";
    }
    @RequestMapping("/admin/checkStat")
    public String usersManage(){
        return "admin/checkStat";
    }
}
