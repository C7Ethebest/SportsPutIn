package com.sportspunchin.Controller;

import com.sportspunchin.mapper.MyPEPlanMapper;
import com.sportspunchin.pojo.MyPEPlan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/MyPEPlan")
@RestController
public class MyPEPlanController {
    @Autowired
    private MyPEPlanMapper myPEPlanMapper;

    @GetMapping("/findmyAll")
    public List<MyPEPlan> findmyAll(){
        return myPEPlanMapper.selectList(null);
    }

}
