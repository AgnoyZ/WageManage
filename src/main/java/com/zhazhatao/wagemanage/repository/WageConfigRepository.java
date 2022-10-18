package com.zhazhatao.wagemanage.repository;

import com.zhazhatao.wagemanage.entity.WageConfig;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WageConfigRepository {
    int selectAllWageConfig();
    List<WageConfig> selectAllWageConfigByPage(@Param("startIndex") int startIndex, @Param("perPageSize") int perPageSize);
    WageConfig selectWageConfigByDuty(String duty);

    int updateWageConfig(WageConfig wageConfig);
}
