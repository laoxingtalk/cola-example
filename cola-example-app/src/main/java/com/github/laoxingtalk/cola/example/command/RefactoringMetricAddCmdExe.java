package com.github.laoxingtalk.cola.example.command;

import com.alibaba.cola.dto.Response;
import com.github.laoxingtalk.cola.example.domain.metrics.techcontribution.ContributionMetric;
import com.github.laoxingtalk.cola.example.domain.metrics.techcontribution.RefactoringLevel;
import com.github.laoxingtalk.cola.example.domain.metrics.techcontribution.RefactoringMetric;
import com.github.laoxingtalk.cola.example.domain.metrics.techcontribution.RefactoringMetricItem;
import com.github.laoxingtalk.cola.example.domain.user.UserProfile;
import com.github.laoxingtalk.cola.example.dto.RefactoringMetricAddCmd;
import com.github.laoxingtalk.cola.example.domain.gateway.MetricGateway;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * RefactoringMetricAddCmdExe
 *
 * @author Frank Zhang
 * @date 2019-03-04 11:15 AM
 */
@Component
public class RefactoringMetricAddCmdExe{

    @Autowired
    private MetricGateway metricGateway;

    public Response execute(RefactoringMetricAddCmd cmd) {
        RefactoringMetricItem refactoringMetricItem = new RefactoringMetricItem();
        BeanUtils.copyProperties(cmd.getRefactoringMetricCO(), refactoringMetricItem);
        refactoringMetricItem.setSubMetric(new RefactoringMetric(new ContributionMetric(new UserProfile(cmd.getRefactoringMetricCO().getOwnerId()))));
        refactoringMetricItem.setRefactoringLevel(RefactoringLevel.valueOf(cmd.getRefactoringMetricCO().getRefactoringLevel()));
        metricGateway.save(refactoringMetricItem);
        return Response.buildSuccess();
    }
}