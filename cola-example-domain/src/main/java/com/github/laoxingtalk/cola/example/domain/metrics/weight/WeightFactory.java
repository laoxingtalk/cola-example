package com.github.laoxingtalk.cola.example.domain.metrics.weight;

import com.github.laoxingtalk.cola.example.domain.user.Role;

public class WeightFactory {
    public static Weight get(Role role){
        if(role == Role.DEV){
            return DevWeight.singleton;
        }
        if(role == Role.QA){
            return QAWeight.singleton;
        }
        return OtherWeight.singleton;
    }
}
