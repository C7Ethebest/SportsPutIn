package com.sportspunchin.Service;

import com.github.pagehelper.PageInfo;
import com.sportspunchin.pojo.User;

import java.util.HashMap;
import java.util.List;



public interface UserService {

    PageInfo findAllUser (String username, int pageNum, int pageSize) throws Exception ;


    List<User> findUserByMap(HashMap<String,String> queryMap);
}
