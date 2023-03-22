package com.skura.entity.response;

import com.skura.entity.Mockdata;
import lombok.Data;

/**
 * @Author 59264
 * @Date 2023/3/21
 */

@Data
public class OrderResponse {
    //0 金额不对  1 正确  2 单号不存在
    private String status;
    private Mockdata mockdata;
}

