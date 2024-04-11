package com.cwr.mapper;

import com.cwr.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {
    List<Emp> list(String name, Short gender, LocalDate begin, LocalDate end, Integer pageOffset, Integer pageSize);

    void deleteEmpsByIds(List<Integer> ids);
}
