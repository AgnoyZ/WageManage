package com.zhazhatao.wagemanage.controller.admin;

import com.alibaba.fastjson.JSONObject;
import com.zhazhatao.wagemanage.entity.CheckStat;
import com.zhazhatao.wagemanage.entity.Employee;
import com.zhazhatao.wagemanage.entity.Wage;
import com.zhazhatao.wagemanage.entity.WageConfig;
import com.zhazhatao.wagemanage.service.admin.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdminEmployeeController extends AdminBaseController{
    @Autowired
    private AdminService adminService;

    @RequestMapping("/admin/selectAllEmployeeByPage")
    public JSONObject selectAllEmployeeByPage(int page,int limit,@RequestParam(required = false,defaultValue = "") String employeeName){
        JSONObject jsonObject = new JSONObject();
        List<Employee> data = adminService.selectAllEmployeeByPage(page, limit,employeeName);
        int count;
        if (employeeName != null){
            count = adminService.selectAllEmployeeEmployeeNameLike(employeeName);
        }else {
            count = adminService.selectAllEmployee();
        }
        jsonObject.put("code",0);
        jsonObject.put("msg","");
        jsonObject.put("count",count);
        jsonObject.put("data",data);
        return jsonObject;
    }

    @RequestMapping("/admin/deleteEmployee")
    public JSONObject deleteEmployee(@RequestBody String employeeId){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("msg",adminService.deleteEmployee(employeeId));
        return jsonObject;
    }

    @RequestMapping("/admin/batchDeleteEmployee")
    public JSONObject batchDeleteEmployee(@RequestBody List<Employee> employees){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("msg",adminService.batchDeleteEmployee(employees));
        return jsonObject;
    }

    @RequestMapping("/admin/insertEmployee")
    public JSONObject insertEmployee(@RequestBody Employee employee){
        String msg = adminService.insertEmployee(employee);
        if ("添加成功".equals(msg)){
            WageConfig wageConfig = adminService.selectWageConfigByDuty(employee.getDuty());
            Wage wage = new Wage();
            CheckStat checkStat = new CheckStat();
            wage.setEmployeeId(employee.getEmployeeId());
            wage.setEmployeeName(employee.getEmployeeName());
            wage.setBaseWage(wageConfig.getBaseWage());
            wage.setEtcWage(wageConfig.getEtcStandard());
            wage.setBonusWage(wageConfig.getBonus());
            wage.setTotalWage(wageConfig.getBaseWage().add(wageConfig.getEtcStandard()).add(wageConfig.getBonus()));
            checkStat.setEmployeeId(employee.getEmployeeId());
            checkStat.setEmployeeName(employee.getEmployeeName());
            adminService.insertCheckStat(checkStat);
            adminService.insertWage(wage);
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("msg",msg);
        return jsonObject;
    }

    @RequestMapping("/admin/updateEmployee")
    public JSONObject updateEmployee(@RequestBody Employee employee){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("msg",adminService.updateEmployee(employee));
        return jsonObject;
    }

}
