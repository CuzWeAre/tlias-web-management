package com.cwr.pojo;

import com.cwr.pojo.validation.EmpAddGroup;
import com.cwr.pojo.validation.EmpLoginGroup;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Emp {
    private Integer id;
    @NotNull(message = "username不能为空",groups = {EmpLoginGroup.class, EmpAddGroup.class})
    private String username;
    @NotNull(message = "password不能为空",groups = EmpLoginGroup.class)
    private String password;
    @NotNull(message = "name不能为空",groups = EmpAddGroup.class)
    private String name;
    @NotNull(message = "gender不能为空",groups = EmpAddGroup.class)
    private Short gender;
    private String image;
    private Short job;
    private LocalDate entrydate;
    private Integer deptId;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
