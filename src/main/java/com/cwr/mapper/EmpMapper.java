package com.cwr.mapper;

import com.cwr.pojo.Emp;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {
    List<Emp> list(String name, Short gender, LocalDate begin, LocalDate end);

    void deleteEmpsByIds(List<Integer> ids);

    void add(Emp emp);

    Emp findById(Integer id);

    void update(Emp emp);

    Long count();
}
