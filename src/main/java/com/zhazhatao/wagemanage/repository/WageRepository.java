package com.zhazhatao.wagemanage.repository;

import com.zhazhatao.wagemanage.entity.Wage;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WageRepository {
    int selectAllWage();
    int selectAllWageEmployeeNameLike(String employeeName);
    List<Wage> selectAllWageByPage(@Param("startIndex") int startIndex, @Param("perPageSize") int perPageSize,@Param("employeeName") String employeeName);
    Wage selectWageByEmployeeId(String employeeId);
    int insertWage(Wage wage);
    int updateWage(Wage wage);
}
