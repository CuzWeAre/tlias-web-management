package com.cwr.controller;

import com.cwr.pojo.Emp;
import com.cwr.pojo.PageBean;
import com.cwr.pojo.Result;
import com.cwr.service.EmpService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
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
    public Result list(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Short gender,
            @RequestParam(required = false) @DateTimeFormat() LocalDate begin,
            @RequestParam(required = false) @DateTimeFormat() LocalDate end,
            @RequestParam(required = false, defaultValue = "1") Integer page,
            @RequestParam(required = false, defaultValue = "10") Integer pageSize) {
        log.info("员工列表查询");
        List<Emp> empList = empService.list(name, gender, begin, end, page, pageSize);
        return Result.success(empList);
    }

    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable("ids") List<Integer> ids) {
        log.info("删除部门 : {}", ids);
        empService.deleteEmpsByIds(ids);
        return Result.success();
    }

    @PostMapping
    public Result add(@RequestBody @Valid Emp emp) {
        empService.add(emp);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result findById(@PathVariable Integer id) {
        Emp emp = empService.findById(id);
        return Result.success(emp);
    }

    @PutMapping
    public Result update(@RequestBody Emp emp) {
        if (emp.getId() == null || emp.getUsername() == null || emp.getName() == null || emp.getGender() == null) {
            return Result.error();
        }
        empService.update(emp);
        return Result.success();
    }
}
