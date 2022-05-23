package com.sportspunchin.Controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.pagehelper.Page;
import com.github.pagehelper.page.PageParams;
import com.sportspunchin.mapper.PEPlanMapper;
import com.sportspunchin.pojo.PEPlan;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Book;
import java.util.List;
import java.util.Map;

@RequestMapping("/Sport")
@RestController
public class PEPlanController {
    @Autowired
    private PEPlanMapper pePlanMapper;

    @GetMapping("/findAll")
    public List<PEPlan> findAll(){
        return pePlanMapper.selectList(null);


    }
//    @Configuration
//    public class MyBatisPlusConfig {
//        @Bean
//        public PaginationInterceptor paginationInterceptor() {
//            PaginationInterceptor page = new PaginationInterceptor();
//            return page;
//        }
//    }





//    public IPage<Map> test() {
//        Integer currentPage = 1; //当前页数：显示第一页数据
//        Integer pageSize = 2;    //每页显示多少：每页显示2条数据
//        Page<Map> page = new Page<Map>(currentPage, pageSize);
//        IPage<Map> findList = PEPlanService.findlistpage(page);
//        return findList;
//    }

}
