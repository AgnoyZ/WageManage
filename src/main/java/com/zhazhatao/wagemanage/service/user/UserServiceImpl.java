package com.zhazhatao.wagemanage.service.user;


import com.zhazhatao.wagemanage.entity.Wage;
import com.zhazhatao.wagemanage.repository.WageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    WageRepository wageRepository;

    @Override
    public int selectAllWage() {
        int count = wageRepository.selectAllWage();
        return count;
    }

    @Override
    public int selectAllWageEmployeeNameLike(String employeeName) {
        int count = wageRepository.selectAllWageEmployeeNameLike(employeeName);
        return count;
    }

    @Override
    public List<Wage> selectAllWageByPage(int page, int limit, String employeeName) {
        List<Wage> list = wageRepository.selectAllWageByPage((page-1)*limit,limit,employeeName);
        return list;
    }
}
