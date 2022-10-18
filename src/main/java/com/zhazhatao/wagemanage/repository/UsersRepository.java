package com.zhazhatao.wagemanage.repository;

import com.zhazhatao.wagemanage.entity.Users;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UsersRepository {
    List<Users> login(@Param("userName") String userName,@Param("userPassword") String userPassword);
}
