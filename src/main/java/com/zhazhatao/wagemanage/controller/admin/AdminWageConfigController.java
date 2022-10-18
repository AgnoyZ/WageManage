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
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class AdminWageConfigController extends AdminBaseController{
    @Autowired
    private AdminService adminService;

    @RequestMapping("/admin/selectAllWageConfigByPage")
    public JSONObject selectAllWageConfigByPage(int page, int limit){
        JSONObject jsonObject = new JSONObject();
        List<WageConfig> data = adminService.selectAllWageConfigByPage(page, limit);
        int count = adminService.selectAllWageConfig();
        jsonObject.put("code",0);
        jsonObject.put("msg","");
        jsonObject.put("count",count);
        jsonObject.put("data",data);
        return jsonObject;
    }

    @RequestMapping("/admin/updateWageConfig")
    public JSONObject updateWageConfig(@RequestBody WageConfig wageConfig){
        JSONObject jsonObject = new JSONObject();
        String msg = adminService.updateWageConfig(wageConfig);
        if ("更新成功".equals(msg)){
            List<Employee> employeeList = adminService.selectAllEmployeeByDuty(wageConfig.getDuty());
            for (Employee employee:
                 employeeList) {
                Wage wage = adminService.selectWageByEmployeeId(employee.getEmployeeId());
                CheckStat checkStat = adminService.selectCheckStatByEmployeeId(employee.getEmployeeId());
                BigDecimal overtimeWage = wageConfig.getDayWage().multiply(BigDecimal.valueOf(checkStat.getOvertimeDay() * wageConfig.getOvertimeJob()));
                BigDecimal evectionWage = wageConfig.getEvectionStandard().multiply(BigDecimal.valueOf(checkStat.getEvectionDay()));
                BigDecimal absentWage = wageConfig.getAbsentStandard().multiply(BigDecimal.valueOf(checkStat.getAbsentDay()));
                BigDecimal lateWage = wageConfig.getLateStandard().multiply(BigDecimal.valueOf(checkStat.getLateDay()));
                BigDecimal totalWage = wageConfig.getBaseWage().add(overtimeWage).add(evectionWage).add(wageConfig.getEtcStandard()).add(wageConfig.getBonus()).subtract(absentWage).subtract(lateWage);
                wage.setBaseWage(wageConfig.getBaseWage());
                wage.setOvertimeWage(overtimeWage);
                wage.setEvectionWage(evectionWage);
                wage.setAbsentWage(absentWage);
                wage.setLateWage(lateWage);
                wage.setEtcWage(wageConfig.getEtcStandard());
                wage.setBonusWage(wageConfig.getBonus());
                wage.setTotalWage(totalWage);
                adminService.updateWage(wage);
            }
        }
        jsonObject.put("msg",msg);
        return jsonObject;
    }
}
