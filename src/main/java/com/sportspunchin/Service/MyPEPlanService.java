package com.sportspunchin.Service;

import com.sportspunchin.pojo.MyPEPlan;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MyPEPlanService {

    List<MyPEPlan> findmyAll();
}
