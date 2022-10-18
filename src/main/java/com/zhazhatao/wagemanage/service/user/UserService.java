package com.zhazhatao.wagemanage.service.user;


import com.zhazhatao.wagemanage.entity.Wage;

import java.util.List;

public interface UserService {
    int selectAllWage();
    int selectAllWageEmployeeNameLike(String employeeName);
    List<Wage> selectAllWageByPage(int page, int limit,String employeeName);
}
