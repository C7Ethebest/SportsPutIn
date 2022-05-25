package com.sportspunchin.Controller;

import com.sportspunchin.mapper.MyPEPlanMapper;
import com.sportspunchin.pojo.MyPEPlan;
import com.sportspunchin.pojo.PEPlan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping("/deleteMyPEPlan/{mypeid}")
    public void deleteMyPEPlan(@PathVariable("mypeid") Integer mypeid){
        myPEPlanMapper.deleteById(mypeid);
    }

    @PostMapping("/AddMyPEPlan")
    public String AddMyPEPlan(@RequestBody MyPEPlan mypePlan){

        Integer result = myPEPlanMapper.insert(mypePlan);
        if (result > 0){
            return "success";
        }else {
            return "error";
        }
    }

}
