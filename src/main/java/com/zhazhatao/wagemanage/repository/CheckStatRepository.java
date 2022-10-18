package com.zhazhatao.wagemanage.repository;

import com.zhazhatao.wagemanage.entity.CheckStat;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CheckStatRepository {
    int selectAllCheckStat();
    int selectAllCheckStatEmployeeNameLike(String employeeName);
    List<CheckStat> selectAllCheckStatByPage(@Param("startIndex") int startIndex, @Param("perPageSize") int perPageSize,@Param("employeeName") String employeeName);
    CheckStat selectCheckStatByEmployeeId(String employeeId);
    int insertCheckStat(CheckStat checkStat);

    int updateCheckStat(CheckStat checkStat);
}
