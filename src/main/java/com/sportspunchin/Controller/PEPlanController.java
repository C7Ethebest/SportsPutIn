package com.sportspunchin.Controller;

import com.github.pagehelper.PageInfo;
import com.sportspunchin.mapper.PEPlanMapper;
import com.sportspunchin.pojo.PEPlan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequestMapping("/Sport")
@RestController
public class PEPlanController {
    @Autowired
    private PEPlanMapper pePlanMapper;

    //查全部
    @GetMapping("/findAll")
    public List<PEPlan> findAll(){
        return pePlanMapper.selectList(null);
    }

    //删
    @DeleteMapping("/deletePEPlan/{peid}")
    public void deletePEPlan(@PathVariable("peid") Integer peid){
        pePlanMapper.deleteById(peid);
    }

    //增
    @PostMapping("/AddPEPlan")
    public String AddPEPlan(@RequestBody PEPlan pePlan){

        Integer result = pePlanMapper.insert(pePlan);
        if (result > 0){
            return "success";
        }else {
            return "error";
        }
    }

//    //分页查询
//   @GetMapping("getAll")
//    public PageInfo<PEPlan> getAll(Long peid, int pageNum, int pageSize){
//       System.out.println(peid + pageNum + pageSize);
//       System.out.println();
//       return
//   }


    //根本不需要的编辑
//    @GetMapping("/updateByPeid/{peid}")
//    public void updateByPeid(){
//        PEPlan pePlan = new PEPlan();
//        pePlan.setPename("跳伞");
//        pePlan.setTimes("两天");
//        pePlan.setCoach("马老师");
//        pePlan.setPrice(100);
//        //被更改的用户
//        pePlan.setPeid(@RequestBody("peid") Integer peid);
//        //更新所有非null的值
//        int i = pePlanMapper.updateById(pePlan);
//        System.out.println("影响行数"+i);
//    }



//    @Configuration
//    public class MyBatisPlusConfig {
//        @Bean
//        public PaginationInterceptor paginationInterceptor() {
//            PaginationInterceptor page = new PaginationInterceptor();
//            return page;
//        }
//    }


//    @Override
//    public PageInfo<Book> listBookAdd(BookQueryAdd bookQueryAdd) {
//        PageHelper.startPage(bookQueryAdd.getPageNum(), bookQueryAdd.getPageSize());
//        return new PageInfo<Book>(bookDao.listBookAdd(bookQueryAdd));
//    }



//    public IPage<Map> test() {
//        Integer currentPage = 1; //当前页数：显示第一页数据
//        Integer pageSize = 2;    //每页显示多少：每页显示2条数据
//        Page<Map> page = new Page<Map>(currentPage, pageSize);
//        IPage<Map> findList = PEPlanService.findlistpage(page);
//        return findList;
//    }

}
