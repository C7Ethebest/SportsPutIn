package com.sportspunchin.Controller;

import com.sportspunchin.mapper.MyPEPlanMapper;
import com.sportspunchin.mapper.PEPlanMapper;
import com.sportspunchin.pojo.MyPEPlan;
import com.sportspunchin.pojo.PEPlan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequestMapping("/MyPEPlan")
@RestController
public class MyPEPlanController {
    @Autowired
    private MyPEPlanMapper myPEPlanMapper;

    @Autowired
    private PEPlanMapper pePlanMapper;

    //查全部
    @GetMapping("/findmyAll")
    public List<MyPEPlan> findmyAll(){
        return myPEPlanMapper.selectList(null);
    }

    //删
    @DeleteMapping("/deleteMyPEPlan/{mypeid}")
    public void deleteMyPEPlan(@PathVariable("mypeid") Integer mypeid){
        myPEPlanMapper.deleteById(mypeid);
    }


    //根据id添加
    @PostMapping("/BuyPEPlan/{peid}")
    public String BuyPEPlan(@PathVariable("peid") Integer peid){
        PEPlan pePlan = pePlanMapper.selectById(peid);

        MyPEPlan myPEPlan = new MyPEPlan();
        myPEPlan.setMypename(pePlan.getPename());
        myPEPlan.setMytimes(pePlan.getTimes());
        myPEPlan.setMycoach(pePlan.getCoach());
        myPEPlan.setPrice(pePlan.getPrice());

        Integer result = myPEPlanMapper.insert(myPEPlan);

        if (result > 0){
            return "success";
        }else {
            return "error";
        }
    }





}
