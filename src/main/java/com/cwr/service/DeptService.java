package com.cwr.service;

import com.cwr.pojo.Dept;

import java.util.List;

public interface DeptService {
    // 查询全部部门数据
    List<Dept> list();

    void delete(Integer id);

    void create(Dept dept);

    Dept getDeptById(Integer id);

    void update(Dept dept);
}
