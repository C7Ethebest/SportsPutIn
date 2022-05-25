package com.sportspunchin.Controller;


import com.sportspunchin.mapper.PEPlanMapper;
import com.sportspunchin.pojo.PEPlan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RequestMapping("/Sport")
@RestController
public class PEPlanController {
    @Autowired
    private PEPlanMapper pePlanMapper;

    @GetMapping("/findAll")
    public List<PEPlan> findAll(){
        return pePlanMapper.selectList(null);
    }

    @DeleteMapping("/deletePEPlan/{peid}")
    public void deletePEPlan(@PathVariable("peid") Integer peid){
        pePlanMapper.deleteById(peid);
    }

    @PostMapping("/AddPEPlan")
    public String AddPEPlan(@RequestBody PEPlan pePlan){

        Integer result = pePlanMapper.insert(pePlan);
        if (result > 0){
            return "success";
        }else {
            return "error";
        }
    }


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
