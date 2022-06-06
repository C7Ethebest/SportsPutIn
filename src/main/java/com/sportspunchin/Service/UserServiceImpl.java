package com.sportspunchin.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sportspunchin.mapper.UserMapper;
import com.sportspunchin.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public PageInfo findAllUser (String username, int pageNum, int pageSize) throws Exception {
        //开启分页
        PageHelper.startPage(pageNum, pageSize);
        List<User> userList =  userMapper.findAllUser(username);
        PageInfo pageInfo = new PageInfo(userList);
        return pageInfo;
    }

    @Override
    public List<User> findUserByMap(HashMap<String,String> queryMap){
        return userMapper.findUserByMap(queryMap);
    }
}