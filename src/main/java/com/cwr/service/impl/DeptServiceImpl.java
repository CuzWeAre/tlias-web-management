package com.cwr.service.impl;

import com.cwr.mapper.DeptMapper;
import com.cwr.pojo.Dept;
import com.cwr.service.DeptService;
import org.springframework.stereotype.Service;

import java.util.List;

//交给ioc管理，成为bean
@Service

public class DeptServiceImpl implements DeptService {

    private final DeptMapper deptMapper;

    public DeptServiceImpl(DeptMapper deptMapper) {
        this.deptMapper = deptMapper;
    }

    @Override
    public List<Dept> list() {
        return deptMapper.list();
    }

    @Override
    public void delete(Integer id) {
        deptMapper.delete(id);
    }

    @Override
    public void add(Dept dept) {
        deptMapper.add(dept);
    }

    @Override
    public Dept getDeptById(Integer id) {
        return deptMapper.getDeptById(id);
    }

    @Override
    public void update(Dept dept) {
        deptMapper.update(dept);
    }
}
