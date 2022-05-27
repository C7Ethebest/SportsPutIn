package com.sportspunchin.pojo.query;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class PEPlanQuery {
    private Integer pageNum = 1;
    private Integer pageSize = 5;
    private String pename;
}
