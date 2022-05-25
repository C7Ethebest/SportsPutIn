package com.sportspunchin.Service;

import com.sportspunchin.mapper.MyPEPlanMapper;
import com.sportspunchin.pojo.MyPEPlan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MyPEPlanServiceImpl implements MyPEPlanService{
    private MyPEPlanMapper myPEPlanMapper;

    @Override
    public List<MyPEPlan> findmyAll() {
        return myPEPlanMapper.selectList(null);
    }
}
