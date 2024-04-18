package com.cwr.controller;

import com.cwr.pojo.Emp;
import com.cwr.pojo.PageBean;
import com.cwr.pojo.Result;
import com.cwr.pojo.validation.EmpAddGroup;
import com.cwr.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/emps")
public class EmpController {

    private final EmpService empService;

    public EmpController(EmpService empService) {
        this.empService = empService;
    }

    @GetMapping
    public Result<PageBean> list(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Short gender,
            @RequestParam(required = false) @DateTimeFormat() LocalDate begin,
            @RequestParam(required = false) @DateTimeFormat() LocalDate end,
            @RequestParam(required = false, defaultValue = "1") Integer page,
            @RequestParam(required = false, defaultValue = "10") Integer pageSize) {
        log.info("员工列表查询");
        PageBean pageBean = empService.page(name, gender, begin, end, page, pageSize);
        return Result.success(pageBean);
    }

    @DeleteMapping("/{ids}")
    public Result<Object> delete(@PathVariable("ids") List<Integer> ids) {
        log.info("删除员工 : {}", ids);
        empService.deleteEmpsByIds(ids);
        return Result.success();
    }

    @PostMapping
    public Result<Object> add(@Validated(EmpAddGroup.class) @RequestBody Emp emp) {
        empService.add(emp);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result<Emp> findById(@PathVariable Integer id) {
        Emp emp = empService.findById(id);
        return Result.success(emp);
    }

    @PutMapping
    public Result<Object> update(@RequestBody Emp emp) {
        if (emp.getId() == null || emp.getUsername() == null || emp.getName() == null || emp.getGender() == null) {
            return Result.error();
        }
        empService.update(emp);
        return Result.success();
    }
}
