package com.skura.entity.request;

import com.skura.entity.Mockdata;
import lombok.Data;

import java.util.List;

/**
 * @Author 59264
 * @Date 2023/3/21
 */
@Data
public class OrderRequest {
    private List<Mockdata> orders;
}
