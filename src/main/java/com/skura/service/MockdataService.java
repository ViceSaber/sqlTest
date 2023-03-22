package com.skura.service;

import com.skura.entity.Mockdata;
import com.baomidou.mybatisplus.extension.service.IService;
import com.skura.entity.request.OrderRequest;
import com.skura.entity.request.PeriodRequest;
import com.skura.entity.response.OrderResponse;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhangqiang
 * @since 2023-03-20
 */
public interface MockdataService extends IService<Mockdata> {

    Long queryTradeSumsByPeriod(PeriodRequest periodReq);

    List<OrderResponse> checkOrders(OrderRequest orderRequest);
}
