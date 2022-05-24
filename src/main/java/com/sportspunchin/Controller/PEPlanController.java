package com.sportspunchin.Controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sportspunchin.mapper.PEPlanMapper;
import com.sportspunchin.pojo.PEPlan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.awt.print.Book;
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

    @GetMapping("/deletePEPlan")
    public String deletePEPlan(@PathVariable("peid") Integer peid, RedirectAttributes attributes){
        Integer b = pePlanMapper.deleteById(peid);
        if (b > 0){
            attributes.addAttribute("message","删除计划成功");
            return "redirect:";
        }else {
            attributes.addFlashAttribute("message","删除计划失败");
            return "redirect:";
        }
    }

//    @PostMapping("/AddPEPlan")
//    public String AddPEPlan(@PathVariable("peid") Integer peid, RedirectAttributes attributes){
//        PEPlan pePlan = new PEPlan();
//        Integer b = pePlanMapper.insert(pePlan);
//        if (b > 0){
//            attributes.addAttribute("message","添加计划成功");
//            return "redirect:";
//        }else {
//            attributes.addFlashAttribute("message","删除计划失败");
//            return "redirect:";
//        }
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
