package com.github.laoxingtalk.cola.example.dto;

import com.github.laoxingtalk.cola.example.dto.clientobject.PaperMetricCO;
import com.github.laoxingtalk.cola.example.dto.clientobject.PatentMetricCO;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * PaperMetricAddCmd
 *
 * @author Frank Zhang
 * @date 2019-03-03 11:38 AM
 */
@Data
public class PaperMetricAddCmd extends CommonCommand{
    @NotNull
    private PaperMetricCO paperMetricCO;
}