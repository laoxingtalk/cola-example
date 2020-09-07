package com.github.laoxingtalk.cola.example.domain.metrics.devquality;

import com.github.laoxingtalk.cola.example.domain.metrics.MainMetric;
import com.github.laoxingtalk.cola.example.domain.metrics.MainMetricType;
import com.github.laoxingtalk.cola.example.domain.user.UserProfile;
import lombok.Data;

@Data
public class DevQualityMetric extends MainMetric {

    private BugMetric bugMetric;

    public DevQualityMetric(UserProfile metricOwner){
        this.metricOwner = metricOwner;
        metricOwner.setDevQualityMetric(this);
        this.metricMainType = MainMetricType.DEV_QUALITY;
    }

    @Override
    public double getWeight() {
        return metricOwner.getWeight().getDevQualityWeight();
    }
}
