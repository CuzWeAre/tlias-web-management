package com.cwr.service.impl;

import com.cwr.mapper.EmpMapper;
import com.cwr.pojo.Emp;
import com.cwr.pojo.PageBean;
import com.cwr.service.EmpService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    private final EmpMapper empMapper;

    public EmpServiceImpl(EmpMapper empMapper) {
        this.empMapper = empMapper;
    }


    @Override
    public PageBean page(String name, Short gender, LocalDate begin, LocalDate end, Integer page, Integer pageSize) {
        /*
            page = page == null ? 1 : page;
            pageSize = pageSize == null ? 10 : pageSize;
        */

        //1.设置分页参数
        PageHelper.startPage(page, pageSize);

        //2.执行查询
        List<Emp> empList = empMapper.list(name, gender, begin, end);
        Page<Emp> empPage = (Page<Emp>) empList;

        //3.封装PageBean对象
        return new PageBean(empPage.getTotal(),empPage.getResult());
    }

    @Override
    public void deleteEmpsByIds(List<Integer> ids) {
        empMapper.deleteEmpsByIds(ids);
    }

    @Override
    public void add(Emp emp) {
        empMapper.add(emp);
    }

    @Override
    public Emp findById(Integer id) {
        return empMapper.findById(id);
    }

    @Override
    public void update(Emp emp) {
        empMapper.update(emp);
    }
}
