package com.cwr.service;

import com.cwr.pojo.Emp;

import java.time.LocalDate;
import java.util.List;

public interface EmpService {
    List<Emp> list(String name, Short gender, LocalDate begin, LocalDate end, Integer page, Integer pageSize);

    void deleteEmpsByIds(List<Integer> ids);
}
