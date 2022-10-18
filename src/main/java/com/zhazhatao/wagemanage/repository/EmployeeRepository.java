package com.zhazhatao.wagemanage.repository;

import com.zhazhatao.wagemanage.entity.Employee;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EmployeeRepository {

    int selectAllEmployee();
    int selectAllEmployeeEmployeeNameLike(String employeeName);
    List<Employee> selectAllEmployeeByPage(@Param("startIndex") int startIndex, @Param("perPageSize") int perPageSize,@Param("employeeName") String employeeName);
    Employee selectEmployeeByEmployeeId(String employeeId);
    List<Employee> selectAllEmployeeByDuty(String duty);
    int insertEmployee(Employee employee);
    boolean deleteEmployee(String employeeId);
    long batchDeleteEmployee(List<Employee> employees);
    int updateEmployee(Employee employee);
}
