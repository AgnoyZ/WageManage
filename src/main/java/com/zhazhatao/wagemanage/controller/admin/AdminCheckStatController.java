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

import java.math.BigDecimal;
import java.util.List;

@RestController
public class AdminCheckStatController extends AdminBaseController{
    @Autowired
    private AdminService adminService;

    @RequestMapping("/admin/selectAllCheckStatByPage")
    public JSONObject selectAllCheckStatByPage(int page, int limit,@RequestParam(required = false,defaultValue = "") String employeeName){
        JSONObject jsonObject = new JSONObject();
        List<CheckStat> data = adminService.selectAllCheckStatByPage(page, limit,employeeName);
        int count;
        if (employeeName != null){
            count = adminService.selectAllCheckStatEmployeeNameLike(employeeName);
        }else {
            count = adminService.selectAllCheckStat();
        }
        jsonObject.put("code",0);
        jsonObject.put("msg","");
        jsonObject.put("count",count);
        jsonObject.put("data",data);
        return jsonObject;
    }

    @RequestMapping("/admin/updateCheckStat")
    public JSONObject updateCheckStat(@RequestBody CheckStat checkStat){
        JSONObject jsonObject = new JSONObject();
        String msg = adminService.updateCheckStat(checkStat);
        if ("更新成功".equals(msg)){
            Employee employee = adminService.selectEmployeeByEmployeeId(checkStat.getEmployeeId());
            WageConfig wageConfig = adminService.selectWageConfigByDuty(employee.getDuty());
            Wage wage = adminService.selectWageByEmployeeId(checkStat.getEmployeeId());
            BigDecimal overtimeWage = wageConfig.getDayWage().multiply(BigDecimal.valueOf(checkStat.getOvertimeDay() * wageConfig.getOvertimeJob()));
            BigDecimal evectionWage = wageConfig.getEvectionStandard().multiply(BigDecimal.valueOf(checkStat.getEvectionDay()));
            BigDecimal absentWage = wageConfig.getAbsentStandard().multiply(BigDecimal.valueOf(checkStat.getAbsentDay()));
            BigDecimal lateWage = wageConfig.getLateStandard().multiply(BigDecimal.valueOf(checkStat.getLateDay()));
            BigDecimal totalWage = wage.getBaseWage().add(overtimeWage).add(evectionWage).add(wage.getEtcWage()).add(wage.getBonusWage()).subtract(absentWage).subtract(lateWage);
            wage.setOvertimeWage(overtimeWage);
            wage.setEvectionWage(evectionWage);
            wage.setAbsentWage(absentWage);
            wage.setLateWage(lateWage);
            wage.setTotalWage(totalWage);
            adminService.updateWage(wage);
        }
        jsonObject.put("msg",msg);
        return jsonObject;
    }
}
