package com.cwr.controller;

import com.cwr.pojo.Dept;
import com.cwr.pojo.Result;
import com.cwr.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    //    @RequestMapping(value = "/depts",method = RequestMethod.GET)
    @GetMapping("/depts")
    public Result list() {
        log.info("查询全部部门数据");

        //调用service查询部门数据
        List<Dept> deptList = deptService.list();
        return Result.success(deptList);
    }
}
