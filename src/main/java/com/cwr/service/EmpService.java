package com.cwr.service;

import com.cwr.pojo.Emp;
import com.cwr.pojo.PageBean;

import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.util.List;

public interface EmpService {
    PageBean page(String name, Short gender, LocalDate begin, LocalDate end, Integer page, Integer pageSize);

    void deleteEmpsByIds(List<Integer> ids);

    void add(Emp emp);

    Emp findById(Integer id);

    void update(Emp emp);

    boolean checkPassword(Emp emp) throws NoSuchAlgorithmException;
}
