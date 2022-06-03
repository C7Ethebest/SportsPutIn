package com.sportspunchin;


import com.sportspunchin.mapper.MyPEPlanMapper;
import com.sportspunchin.mapper.PEPlanMapper;
import com.sportspunchin.pojo.MyPEPlan;
import com.sportspunchin.pojo.PEPlan;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SportsPunchInApplicationTests {

    @Autowired
    private PEPlanMapper pePlanMapper;

    @Autowired
    private MyPEPlanMapper myPEPlanMapper;


    //查全部
    @Test
    public void testSelectAll(){
        List<PEPlan> list = pePlanMapper.selectList(null);
        list.forEach(System.out::println);
    }

    //新增
    @Test
    public void AddPEPlan(){
        PEPlan pePlan = new PEPlan();
        pePlan.setPename("跑步1");
        pePlan.setTimes("一周");
        pePlan.setCoach("马老师");
        pePlan.setPrice(10);
        int pePlan1 = pePlanMapper.insert(pePlan);
        System.out.println(pePlan1);
    }


    //按id查
    @Test
    public void testSelectByid(){
        PEPlan pePlan = pePlanMapper.selectById(1);
        System.out.println(pePlan);
    }


    //按id购买
    @Test
    public void testbuy(){
        PEPlan pePlan = pePlanMapper.selectById(3);
        System.out.println(pePlan);

        MyPEPlan myPEPlan = new MyPEPlan();
        myPEPlan.setMypename(pePlan.getPename());
        myPEPlan.setMytimes(pePlan.getTimes());
        myPEPlan.setMycoach(pePlan.getCoach());
        myPEPlan.setPrice(pePlan.getPrice());

        int mypePlan1 = myPEPlanMapper.insert(myPEPlan);
        System.out.println(mypePlan1);
    }





    //更新
//    @Test
//    public void updatPEPlan(){
//        PEPlan pePlan = new PEPlan();
//        pePlan.setPename("跳伞");
//        pePlan.setTimes("两天");
//        pePlan.setCoach("马老师");
//        pePlan.setPrice(100);
//        //被更改的用户
//        pePlan.setPeid(5);
//        //更新所有非null的值
//        int i = pePlanMapper.updateById(pePlan);
//        System.out.println("影响行数"+i);
//    }




    //分页查询
//    @Test
//     void Page(){
//        Page<PEPlan> page = new Page<>(2,2);
//        Page<PEPlan> result = pePlanMapper.selectPage(page,null).orElse(null);
//        System.out.println(result.getPageSize());
//        System.out.println(result.getTotal());
//        result.getResult().forEach(System.out::println);
//    }

}