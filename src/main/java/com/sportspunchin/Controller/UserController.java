package com.sportspunchin.Controller;

import com.github.pagehelper.PageInfo;
import com.sportspunchin.Service.UserService;
import com.sportspunchin.base.JsonResponse;
import com.sportspunchin.pojo.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

@RequestMapping("/user")
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    //分页查询所有用户
    @ApiOperation(value = "分页查询全部用户", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页码", required = true, dataType = "INTEGER", paramType = "query", defaultValue = "1"),
            @ApiImplicitParam(name = "pageSize", value = "最大条数", required = true, dataType = "INTEGER", paramType = "query", defaultValue = "7")
    })
    @GetMapping("/findAll")
    @ResponseBody
    public JsonResponse findAllUser(String username, int pageNum, int pageSize) throws Exception {
        PageInfo pageInfo = userService.findAllUser(username,pageNum, pageSize);
        JsonResponse jsonResponse = new JsonResponse(0,"成功",pageInfo);
        return jsonResponse;
    }

    @ApiOperation(value = "登录验证", httpMethod = "POST")
    @PostMapping("/login")
    @ResponseBody
    public JsonResponse login(@RequestBody HashMap<String,String> queryMap, HttpServletRequest request) throws  Exception{
        JsonResponse jsonResponse = new JsonResponse();
        List<User> userList=userService.findUserByMap(queryMap);
        if (userList == null || userList.size() ==0){
            return new JsonResponse(1,"未查询到用户");
        }
        request.getSession().setAttribute("user",userList.get(0));
        return new JsonResponse(0,"添加成功",userList.get(0));
    }


}