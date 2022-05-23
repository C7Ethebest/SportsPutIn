package com.sportspunchin.Service;

import java.util.List;
import com.sportspunchin.pojo.PEPlan;
import org.springframework.stereotype.Service;



@Service
public interface PEPlanService {

    List<PEPlan> findAll();

}
