package com.github.laoxingtalk.cola.example.command.query;

import com.alibaba.cola.dto.SingleResponse;
import com.github.laoxingtalk.cola.example.dto.UserProfileGetQry;
import com.github.laoxingtalk.cola.example.dto.clientobject.UserProfileCO;
import com.github.laoxingtalk.cola.example.gatewayimpl.database.UserProfileMapper;
import com.github.laoxingtalk.cola.example.gatewayimpl.database.dataobject.UserProfileDO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class UserProfileGetQryExe {

    @Resource
    private UserProfileMapper userProfileMapper;

    public SingleResponse<UserProfileCO> execute(UserProfileGetQry qry) {
        UserProfileDO userProfileDO = userProfileMapper.getByUserId(qry.getUserId());
        UserProfileCO userProfileCO = new UserProfileCO();
        BeanUtils.copyProperties(userProfileDO, userProfileCO);
        return SingleResponse.of(userProfileCO);
    }

}
