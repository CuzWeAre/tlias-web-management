package com.cwr.controller;

import com.cwr.service.DeptService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emp")
public class EmpController {

    private final DeptService deptService;

    public EmpController(DeptService deptService) {
        this.deptService = deptService;
    }


}
