package com.github.laoxingtalk.cola.example.dto;

import com.github.laoxingtalk.cola.example.dto.clientobject.MiscMetricCO;
import com.github.laoxingtalk.cola.example.dto.clientobject.PatentMetricCO;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * MiscMetricAddCmd
 *
 * @author Frank Zhang
 * @date 2019-03-04 11:04 AM
 */
@Data
public class MiscMetricAddCmd extends CommonCommand{
    @NotNull
    private MiscMetricCO miscMetricCO;
}
