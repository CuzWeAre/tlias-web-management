package com.cwr.mapper;

import com.cwr.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DeptMapper {

    // 查询全部部门
    @Select("SELECT * FROM dept")
    List<Dept> list();

    @Delete("DELETE FROM dept where id=#{id}")
    void delete(Integer id);

    @Insert("INSERT INTO dept (name,create_time,update_time) VALUES (#{name},now(),now())")
    void add(Dept dept);

    @Select("SELECT * FROM dept WHERE id=#{id}")
    Dept getDeptById(Integer id);

    @Update("UPDATE dept SET name = #{name},update_time = now() WHERE id = #{id}")
    void update(Dept dept);
}
