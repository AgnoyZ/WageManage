package com.zhazhatao.wagemanage.controller.admin;

import com.zhazhatao.wagemanage.entity.Users;
import com.zhazhatao.wagemanage.service.admin.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class AdminLoginApi {
    @Autowired
    private AdminService adminService;

    @RequestMapping( "/admin/loginResult")
    public List<Users> loginResult(@RequestBody Map<String, String> user){
       return adminService.loginResult(user.get("userName"),user.get("userPassword"));
    }

}
