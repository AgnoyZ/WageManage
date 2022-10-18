package com.zhazhatao.wagemanage.service.admin;

import com.zhazhatao.wagemanage.entity.*;
import org.springframework.ui.Model;
import java.util.List;

public interface AdminService {
    List<Users> loginResult(String userName,String userPassword);

    int selectAllEmployee();
    int selectAllEmployeeEmployeeNameLike(String employeeName);
    List<Employee> selectAllEmployeeByPage(int page,int limit,String employeeName);
    Employee selectEmployeeByEmployeeId(String employeeId);
    List<Employee> selectAllEmployeeByDuty(String duty);
    String insertEmployee(Employee employee);
    String deleteEmployee(String employeeId);
    String updateEmployee(Employee employee);
    String batchDeleteEmployee(List<Employee> employees);

    int selectAllCheckStat();
    int selectAllCheckStatEmployeeNameLike(String employeeName);
    List<CheckStat> selectAllCheckStatByPage(int page,int limit,String employeeName);
    CheckStat selectCheckStatByEmployeeId(String employeeId);
    String insertCheckStat(CheckStat checkStat);
    String updateCheckStat(CheckStat checkStat);

    Wage selectWageByEmployeeId(String employeeId);
    String insertWage(Wage wage);
    String updateWage(Wage wage);

    WageConfig selectWageConfigByDuty(String duty);
    int selectAllWageConfig();
    List<WageConfig> selectAllWageConfigByPage(int page,int limit);
    String updateWageConfig(WageConfig wageConfig);
}
