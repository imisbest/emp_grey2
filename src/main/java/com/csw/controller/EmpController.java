package com.csw.controller;

import com.csw.entity.Emp;
import com.csw.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("emp")
public class EmpController {
    Integer pageSize = 2;
    @Autowired
    private EmpService empService;

    @RequestMapping("add")
    public String AddEmpAction(Emp emp) {
        System.out.println("emp//" + emp);
        empService.addEmp(emp);
        return "redirect:/emp/queryAndPage?currPage=1";
    }

    @RequestMapping("delete")
    public String DeleteAction(Integer id) {
        empService.deleteAccount(id);
        return "redirect:/emp/queryAndPage?currPage=1";
    }

    @RequestMapping("queryAndPage")
    public String queryAndPage(HttpServletRequest request, Integer currPage) {
        Integer countPage = empService.countPage(pageSize);
        request.setAttribute("countPage", countPage);
        if (currPage == -1) {///分页
            currPage = 0;///分页
        }///分页
        if (currPage == 0) {///分页
            currPage = 1;///分页
        }///分页
        if (currPage == countPage + 1) {///分页
            currPage = countPage;///分页
        }///分页
        List<Emp> empList = empService.queryAllAndByPage(currPage, pageSize, countPage);
        request.setAttribute("empList", empList);
        request.setAttribute("currPage", currPage);
        return "emplist";
    }

    @RequestMapping("update")
    public String UpdateAction(Emp emp, Integer id) {
        emp.setId(id);
        empService.updateBy(emp);
        return "redirect:/emp/queryAndPage?currPage=1";
    }

    @RequestMapping("updateBy")
    public String UpdateQueryByIdAction(HttpServletRequest request, Integer id) {
        Emp ems = empService.findByCardId(id);
        request.setAttribute("ems", ems);
        return "updateEmp";
    }
}
