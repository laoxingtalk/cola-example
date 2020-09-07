package com.github.laoxingtalk.cola.example.dto;

import com.github.laoxingtalk.cola.example.dto.clientobject.ATAMetricCO;
import com.github.laoxingtalk.cola.example.dto.clientobject.PatentMetricCO;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * PatentMetricAddCmd
 *
 * @author Frank Zhang
 * @date 2019-03-03 11:37 AM
 */
@Data
public class PatentMetricAddCmd extends CommonCommand{
    @NotNull
    private PatentMetricCO  patentMetricCO;
}
