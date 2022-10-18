package com.zhazhatao.wagemanage;

import com.zhazhatao.wagemanage.entity.CheckStat;
import com.zhazhatao.wagemanage.entity.Employee;
import com.zhazhatao.wagemanage.entity.Wage;
import com.zhazhatao.wagemanage.service.admin.AdminService;
import com.zhazhatao.wagemanage.service.user.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class WageManageApplicationTests {
    @Autowired
    UserService userService;
    @Autowired
    AdminService adminService;
    @Test
    void contextLoads() {
        System.out.println(adminService.selectAllCheckStatEmployeeNameLike("冯思琪"));
        List<CheckStat> list = adminService.selectAllCheckStatByPage(1,10,"冯思琪");
        for (CheckStat checkStat:
             list) {
            System.out.println(checkStat);
        }
    }

}
