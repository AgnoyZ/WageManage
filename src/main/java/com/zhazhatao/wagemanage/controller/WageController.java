package com.zhazhatao.wagemanage.controller;

import com.alibaba.fastjson.JSONObject;
import com.zhazhatao.wagemanage.entity.Employee;
import com.zhazhatao.wagemanage.entity.Wage;
import com.zhazhatao.wagemanage.service.admin.AdminService;
import com.zhazhatao.wagemanage.service.user.UserService;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class WageController {
    @Autowired
    private UserService userService;
    @RequestMapping("/selectAllWageByPage")
    public JSONObject selectAllWageByPage(int page, int limit, @RequestParam(required = false,defaultValue = "") String employeeName){
        JSONObject jsonObject = new JSONObject();
        List<Wage> data = userService.selectAllWageByPage(page, limit,employeeName);
        int count;
        if (employeeName != null){
            count = userService.selectAllWageEmployeeNameLike(employeeName);
        }else {
            count = userService.selectAllWage();
        }
        jsonObject.put("code",0);
        jsonObject.put("msg","");
        jsonObject.put("count",count);
        jsonObject.put("data",data);
        return jsonObject;
    }
}
