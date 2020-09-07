package com.github.laoxingtalk.cola.example.command.query;

import com.alibaba.cola.dto.MultiResponse;
import com.github.laoxingtalk.cola.example.domain.metrics.SubMetricType;
import com.github.laoxingtalk.cola.example.dto.ATAMetricQry;
import com.github.laoxingtalk.cola.example.dto.clientobject.ATAMetricCO;
import com.github.laoxingtalk.cola.example.gatewayimpl.database.MetricMapper;
import com.github.laoxingtalk.cola.example.gatewayimpl.database.dataobject.MetricDO;
import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Component
public class ATAMetricQryExe{

    @Resource
    private MetricMapper metricMapper;

    public MultiResponse<ATAMetricCO> execute(ATAMetricQry cmd) {
        List<MetricDO> metricDOList = metricMapper.listBySubMetric(cmd.getOwnerId(), SubMetricType.ATA.getMetricSubTypeCode());
        List<ATAMetricCO> ataMetricCOList = new ArrayList<>();
        metricDOList.forEach(metricDO -> {
            ATAMetricCO ataMetricCO = JSON.parseObject(metricDO.getMetricItem(), ATAMetricCO.class);
            ataMetricCO.setOwnerId(metricDO.getUserId());
            ataMetricCOList.add(ataMetricCO);
        });
        return MultiResponse.ofWithoutTotal(ataMetricCOList);
    }

}
