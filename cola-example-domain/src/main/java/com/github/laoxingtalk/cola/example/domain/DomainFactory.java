package com.github.laoxingtalk.cola.example.domain;

import com.github.laoxingtalk.cola.example.domain.user.UserProfile;

public class DomainFactory {

    public static UserProfile getUserProfile(){
        return new UserProfile();
    }

}
