package com.github.laoxingtalk.cola.example.command.query;

import com.alibaba.cola.dto.MultiResponse;
import com.github.laoxingtalk.cola.example.dto.UserProfileListQry;
import com.github.laoxingtalk.cola.example.dto.clientobject.UserProfileCO;
import com.github.laoxingtalk.cola.example.gatewayimpl.database.UserProfileMapper;
import com.github.laoxingtalk.cola.example.gatewayimpl.database.dataobject.UserProfileDO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserProfileListQryExe{

    @Resource
    private UserProfileMapper userProfileMapper;

    public MultiResponse<UserProfileCO> execute(UserProfileListQry qry) {
        List<UserProfileDO> userProfileDOList = userProfileMapper.listByDep(qry.getDep());
        List<UserProfileCO> userProfileCOList = new ArrayList<>();
        userProfileDOList.forEach(userDO -> {
            UserProfileCO userProfileCO = new UserProfileCO();
            BeanUtils.copyProperties(userDO, userProfileCO);
            userProfileCOList.add(userProfileCO);
        });
        return MultiResponse.ofWithoutTotal(userProfileCOList);
    }

}

