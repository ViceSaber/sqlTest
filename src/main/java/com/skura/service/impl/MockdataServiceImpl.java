package com.skura.service.impl;

import com.skura.entity.Mockdata;
import com.skura.entity.request.OrderRequest;
import com.skura.entity.request.PeriodRequest;
import com.skura.entity.response.OrderResponse;
import com.skura.mapper.MockdataMapper;
import com.skura.service.MockdataService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhangqiang
 * @since 2023-03-20
 */
@Service
public class MockdataServiceImpl extends ServiceImpl<MockdataMapper, Mockdata> implements MockdataService {

    @Autowired
    private MockdataMapper mockdataMapper;
    @Override
    public Long queryTradeSumsByPeriod(PeriodRequest periodReq) {

        return mockdataMapper.queryTradeSumsByPeriod(periodReq);
    }

    @Override
    public List<OrderResponse> checkOrders(OrderRequest orderRequest) {
        //获取外部集合
        List<Mockdata> orders = orderRequest.getOrders();
        //集合->id集合
        List<Integer> ids = orders.stream()
                .map(Mockdata::getId)
                .collect(Collectors.toList());

        //内部集合 xml
        List<Mockdata> dbOrders = mockdataMapper.checkOrders(ids);
        Map<Integer, Mockdata> dbOrdersMap = dbOrders.stream()
                .collect(Collectors.toMap(Mockdata::getId, Function.identity()));

        List<OrderResponse> resultList = new ArrayList<>();
        for (Mockdata data : orders) {
            OrderResponse response = new OrderResponse();
            response.setMockdata(data);
            if (!dbOrdersMap.containsKey(data.getId())) {
                //1 不存在
                response.setStatus("2");
                resultList.add(response);
            } else if (data.getAmount().compareTo(dbOrdersMap.get(data.getId()).getAmount())==0) {
                //2 都对
                response.setStatus("1");
                resultList.add(response);
            }
            else
            {
                //3 金额错误
                response.setStatus("0");
                resultList.add(response);
            }
        }
        //1
        return resultList;
    }
}
