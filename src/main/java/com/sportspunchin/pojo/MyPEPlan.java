package com.sportspunchin.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "mypeplan")
public class MyPEPlan {
    //主键自增
    @TableId(type = IdType.AUTO)
    private Integer mypeid;

    private String mypename;
    private String mytimes;
    private String mycoach;
}
