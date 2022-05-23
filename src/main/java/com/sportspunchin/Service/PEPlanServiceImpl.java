package com.sportspunchin.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sportspunchin.mapper.PEPlanMapper;
import com.sportspunchin.pojo.PEPlan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
@Transactional
public class PEPlanServiceImpl implements PEPlanService {
    private PEPlanMapper pePlanMapper;

    @Override
    public List<PEPlan> findAll() {
        return pePlanMapper.selectList(null);
    }




}
