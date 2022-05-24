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
@TableName(value = "peplan")
public class PEPlan {
    //主键自增
    @TableId(value = "peid", type = IdType.AUTO)
    private Integer peid;

    private String pename;
    private String times;
    private String coach;
    private Integer price;

}