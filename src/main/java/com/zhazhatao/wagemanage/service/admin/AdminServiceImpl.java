package com.zhazhatao.wagemanage.service.admin;

import com.zhazhatao.wagemanage.entity.*;
import com.zhazhatao.wagemanage.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService{
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private CheckStatRepository checkStatRepository;
    @Autowired
    private WageRepository wageRepository;
    @Autowired
    private WageConfigRepository wageConfigRepository;

    public List<Users> loginResult(String userName,String userPassword){
        List<Users> list = usersRepository.login(userName,userPassword);
        return list;
    }

    @Override
    public int selectAllEmployee() {
        int count = employeeRepository.selectAllEmployee();
        return count;
    }

    @Override
    public int selectAllEmployeeEmployeeNameLike(String employeeName) {
        int count = employeeRepository.selectAllEmployeeEmployeeNameLike(employeeName);
        return count;
    }

    @Override
    public List<Employee> selectAllEmployeeByPage(int page, int limit,String employeeName) {
        List<Employee> list = employeeRepository.selectAllEmployeeByPage((page-1)*limit,limit,employeeName);
        return list;
    }

    @Override
    public Employee selectEmployeeByEmployeeId(String employeeId) {
        Employee employee = employeeRepository.selectEmployeeByEmployeeId(employeeId);
        return employee;
    }
    @Override
    public List<Employee> selectAllEmployeeByDuty(String duty) {
        List<Employee> list = employeeRepository.selectAllEmployeeByDuty(duty);
        return list;
    }
    @Override
    public String insertEmployee(Employee employee) {
        try {
            employeeRepository.insertEmployee(employee);
        }
        catch (Exception e){
            return "添加失败";
        }
        return "添加成功";
    }
    @Override
    public String deleteEmployee(String employeeId) {
        try {
            employeeRepository.deleteEmployee(employeeId);
        }
        catch (Exception e){
            return "删除失败";
        }
        return "删除成功";
    }
    @Override
    public String batchDeleteEmployee(List<Employee> employees) {
        long res = 0;
        try {
            res = employeeRepository.batchDeleteEmployee(employees);
        }
        catch (Exception e){
            return Long.toString(res)+"条记录删除成功";
        }
        return Long.toString(res)+"条记录删除成功";
    }
    @Override
    public String updateEmployee(Employee employee) {
        int res = employeeRepository.updateEmployee(employee);
        if (res == 1){
            return "更新成功";
        }
        return "更新失败";
    }

    @Override
    public int selectAllCheckStat() {
        int count = checkStatRepository.selectAllCheckStat();
        return count;
    }

    @Override
    public int selectAllCheckStatEmployeeNameLike(String employeeName) {
        int count = checkStatRepository.selectAllCheckStatEmployeeNameLike(employeeName);
        return count;
    }

    @Override
    public List<CheckStat> selectAllCheckStatByPage(int page, int limit,String employeeName) {
        List<CheckStat> list = checkStatRepository.selectAllCheckStatByPage((page-1)*limit,limit,employeeName);
        return list;
    }
    @Override
    public CheckStat selectCheckStatByEmployeeId(String employeeId) {
        CheckStat checkStat = checkStatRepository.selectCheckStatByEmployeeId(employeeId);
        return checkStat;
    }
    @Override
    public String insertCheckStat(CheckStat checkStat) {
        try {
            checkStatRepository.insertCheckStat(checkStat);
        }
        catch (Exception e){
            return "添加失败";
        }
        return "添加成功";
    }
    @Override
    public String updateCheckStat(CheckStat checkStat) {
        int res = checkStatRepository.updateCheckStat(checkStat);
        if (res == 1){
            return "更新成功";
        }
        return "更新失败";
    }


    @Override
    public Wage selectWageByEmployeeId(String employeeId) {
        Wage wage = wageRepository.selectWageByEmployeeId(employeeId);
        return wage;
    }

    @Override
    public String insertWage(Wage wage) {
        try {
            wageRepository.insertWage(wage);
        }
        catch (Exception e){
            return "添加失败";
        }
        return "添加成功";
    }
    @Override
    public String updateWage(Wage wage) {
        int res = wageRepository.updateWage(wage);
        if (res == 1){
            return "更新成功";
        }
        return "更新失败";
    }

    @Override
    public int selectAllWageConfig() {
        int count = wageConfigRepository.selectAllWageConfig();
        return count;
    }
    @Override
    public WageConfig selectWageConfigByDuty(String duty) {
        WageConfig wageConfig = wageConfigRepository.selectWageConfigByDuty(duty);
        return wageConfig;
    }
    @Override
    public List<WageConfig> selectAllWageConfigByPage(int page, int limit) {
        List<WageConfig> list = wageConfigRepository.selectAllWageConfigByPage((page-1)*limit,limit);
        return list;
    }
    @Override
    public String updateWageConfig(WageConfig wageConfig) {
        int res = wageConfigRepository.updateWageConfig(wageConfig);
        if (res == 1){
            return "更新成功";
        }
        return "更新失败";
    }
}
