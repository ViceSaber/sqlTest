package com.skura.mapper;

import com.skura.entity.Mockdata;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.skura.entity.request.OrderRequest;
import com.skura.entity.request.PeriodRequest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhang
 * @since 2023-03-20
 */
@Component
@Mapper
public interface MockdataMapper extends BaseMapper<Mockdata> {
    Long queryTradeSumsByPeriod(@Param("req")PeriodRequest req);

    List<Mockdata> checkOrders(@Param("ids") List ids);
}
