package com.github.laoxingtalk.cola.example.domain.metrics.appquality;

import com.github.laoxingtalk.cola.example.domain.metrics.MainMetric;
import com.github.laoxingtalk.cola.example.domain.metrics.MainMetricType;
import com.github.laoxingtalk.cola.example.domain.metrics.devquality.BugMetric;
import com.github.laoxingtalk.cola.example.domain.user.UserProfile;

public class AppQualityMetric extends MainMetric {

    private AppMetric appMetric;

    public AppQualityMetric(UserProfile metricOwner){
        this.metricOwner = metricOwner;
        metricOwner.setAppQualityMetric(this);
        this.metricMainType = MainMetricType.APP_QUALITY;
    }

    @Override
    public double getWeight() {
        return metricOwner.getWeight().getAppQualityWeight();
    }
}
