package com.sportspunchin;

import com.sportspunchin.mapper.PEPlanMapper;
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

    @Test
    public void testSelectAll(){
        List<PEPlan> list = pePlanMapper.selectList(null);
        list.forEach(System.out::println);
    }



}
