package com.cwr.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Demp {
    private Integer id;
    private String name;
    private LocalDateTime creatTime;
    private LocalDateTime updateTime;
}
