package com.github.laoxingtalk.cola.example.gatewayimpl;

import com.alibaba.cola.logger.Logger;
import com.alibaba.cola.logger.LoggerFactory;
import com.github.laoxingtalk.cola.example.convertor.UserProfileConvertor;
import com.github.laoxingtalk.cola.example.domain.DomainFactory;
import com.github.laoxingtalk.cola.example.domain.gateway.UserProfileGateway;
import com.github.laoxingtalk.cola.example.domain.metrics.techcontribution.ContributionMetric;
import com.github.laoxingtalk.cola.example.domain.metrics.weight.WeightFactory;
import com.github.laoxingtalk.cola.example.domain.user.Role;
import com.github.laoxingtalk.cola.example.domain.user.UserProfile;
import com.github.laoxingtalk.cola.example.gatewayimpl.database.UserProfileMapper;
import com.github.laoxingtalk.cola.example.gatewayimpl.database.dataobject.UserProfileDO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * UserProfileGatewayImpl
 *
 * @author Frank Zhang
 * @date 2020-07-02 12:32 PM
 */
@Component
public class UserProfileGatewayImpl implements UserProfileGateway {
    private static Logger logger = LoggerFactory.getLogger(ContributionMetric.class);

    @Resource
    private UserProfileMapper userProfileMapper;


    public void create(UserProfile userProfile){
        userProfileMapper.create(UserProfileConvertor.toDataObjectForCreate(userProfile));
    }

    public void update(UserProfile userProfile){
        userProfileMapper.update(UserProfileConvertor.toDataObjectForUpdate(userProfile));
    }

    public UserProfile getByUserId(String userId){
        UserProfileDO userProfileDO = userProfileMapper.getByUserId(userId);
        if(userProfileDO == null){
            logger.warn("There is no UserProfile for : "+userId);
            return null;
        }
        UserProfile userProfile = DomainFactory.getUserProfile();
        BeanUtils.copyProperties(userProfileDO, userProfile);
        Role role = Role.valueOf(userProfileDO.getRole());
        userProfile.setRole(role);
        userProfile.setWeight(WeightFactory.get(role));
        return userProfile;
    }

}
