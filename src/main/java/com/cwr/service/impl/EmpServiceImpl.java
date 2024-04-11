package com.cwr.service.impl;

import com.cwr.mapper.EmpMapper;
import com.cwr.pojo.Emp;
import com.cwr.service.EmpService;
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
    public List<Emp> list(String name, Short gender, LocalDate begin, LocalDate end, Integer page, Integer pageSize) {
        /*
            page = page == null ? 1 : page;
            pageSize = pageSize == null ? 10 : pageSize;
        */
        return empMapper.list(name, gender, begin, end, pageSize * (page - 1), pageSize);
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
