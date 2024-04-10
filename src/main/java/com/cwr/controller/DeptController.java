package com.cwr.controller;

import com.cwr.pojo.Dept;
import com.cwr.pojo.Result;
import com.cwr.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/depts/{id}")
    public Result getDeptById(@PathVariable Integer id) {
        log.info("根据ID查询部门");
        Dept dept = deptService.getDeptById(id);
        return Result.success(dept);
    }

    @DeleteMapping("/depts/{id}")
    public Result delete(@PathVariable Integer id) {
        log.info("删除部门");
        deptService.delete(id);
        return Result.success();
    }

    @PostMapping("/depts")
    public Result create(@RequestBody Dept dept) {
        log.info("新建部门");
        deptService.create(dept);
        return Result.success();
    }

    @PutMapping("/depts")
    public Result update(@RequestBody Dept dept) {
        log.info("更新部门信息");
        deptService.update(dept);
        return Result.success();
    }
}
