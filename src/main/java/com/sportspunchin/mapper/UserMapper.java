package com.sportspunchin.mapper;

import com.sportspunchin.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

public interface UserMapper {

    List<User> findAllUser(String username);



    List<User> findUserByMap(@Param("map") HashMap<String, String> queryMap);
}
