package com.skura.controller;


import com.skura.entity.Mockdata;
import com.skura.entity.request.OrderRequest;
import com.skura.entity.request.PeriodRequest;
import com.skura.entity.response.OrderResponse;
import com.skura.service.MockdataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhangqiang
 * @since 2023-03-20
 */
@RestController
@RequestMapping("/mockdata")
public class MockdataController {

    @Autowired
    private MockdataService mockdataService;

    /**
     * 根据名字检索
     * @param name
     * @return
     */
    @GetMapping("test/{name}")
    public List<Mockdata> queryByName(@PathVariable String name){

        List<Mockdata> list = mockdataService.query().eq("name", name).list();
        return list;
    }

    /**
     * 根据时段返回交易总额
     * @param periodReq
     * @return
     */
    @PostMapping("test/queryTradeSums")
    public Long queryTradeSumsByPeriod(@RequestBody PeriodRequest periodReq){

        return mockdataService.queryTradeSumsByPeriod(periodReq);
    }

    /**
     *  对账1.0
     * @param orderRequest
     * @return
     */
    @PostMapping("test/checkOrders")
    public List<OrderResponse> checkOrders(@RequestBody OrderRequest orderRequest){

        return mockdataService.checkOrders(orderRequest);
    }

    /**
     *  对账2.0
     *  1.用户上传为外部订单号&总金额
     *  2.外部订单在数据库拆分为内部订单
     * @param orderRequest
     * @return
     */

    /**
     *  inner join
     * @param orderRequest
     * @return
     */

    /**
     *  in（select id from table xxx）
     * @param orderRequest
     * @return
     */

}

