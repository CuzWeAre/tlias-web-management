package com.cwr.service.impl;

import com.cwr.mapper.DeptMapper;
import com.cwr.pojo.Dept;
import com.cwr.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//交给ioc管理，成为bean
@Service

public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Override
    public List<Dept> list() {
        return deptMapper.list();
    }

    @Override
    public void delete(Integer id) {
        deptMapper.delete(id);
    }

    @Override
    public void create(Dept dept) {
        deptMapper.create(dept);
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
